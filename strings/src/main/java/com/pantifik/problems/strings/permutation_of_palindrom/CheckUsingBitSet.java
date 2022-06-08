package com.pantifik.problems.strings.permutation_of_palindrom;

import java.util.BitSet;
import java.util.Objects;

public class CheckUsingBitSet implements CheckIsPermutationOfPalindrome {

  @Override
  public boolean check(String string) {
    Objects.requireNonNull(string,
        () -> {throw new IllegalArgumentException("The string must not be null");});
    if (string.isBlank()) {
      throw new IllegalArgumentException("The string must not be blank");
    }

    BitSet bitSet = new BitSet();

    for (int c : string.toCharArray()) {
      BitSet mask = new BitSet();
      mask.set(c);
      bitSet.xor(mask);
    }

    int cardinality = bitSet.cardinality();

    return cardinality == 0 || cardinality == 1;
  }
}

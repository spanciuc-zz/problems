package com.pantifik.problems.strings.permutations;

import java.util.Arrays;
import java.util.Objects;

public class CheckArePermutationsUsingSort implements CheckArePermutations {

  @Override
  public boolean check(String first, String second) {

    Objects.requireNonNull(first);
    Objects.requireNonNull(second);

    if (first.length() != second.length()) {
      return false;
    }

    char[] firstArray = first.toCharArray();
    sort(firstArray);
    char[] secondArray = second.toCharArray();
    sort(secondArray);

    return Arrays.equals(firstArray, secondArray);
  }

  private void sort(char[] array) {
    Arrays.sort(array);
  }
}

package com.pantifik.problems.strings.permutation_of_palindrom;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CheckUsingHashSet implements CheckIsPermutationOfPalindrome {

  @Override
  public boolean check(String string) {
    Objects.requireNonNull(string,
        () -> {throw new IllegalArgumentException("The string must not be null");});
    if (string.isBlank()) {
      throw new IllegalArgumentException("The string must not be blank");
    }
    Set<Integer> set = new HashSet<>();
    string.chars()
        .forEach(c -> addOrRemoveIfContains(set, c));
    return set.isEmpty() || set.size() == 1;
  }

  private void addOrRemoveIfContains(Set<Integer> set, int element) {
    if (!set.add(element)) {
      set.remove(element);
    }
  }
}

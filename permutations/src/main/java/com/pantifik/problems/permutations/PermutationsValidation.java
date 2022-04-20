package com.pantifik.problems.permutations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsValidation {

  private PermutationsValidation() {
  }

  static <T> void validateFromList(List<T> from) {
    if (from == null || from.isEmpty()) {
      throw new IllegalArgumentException("The list must not be null or empty");
    }

    checkListForDuplications(from);

  }

  static void validateCount(List<?> from, int count) {
    if (count < 1 || count > from.size()) {
      throw new IllegalArgumentException(
          "The count must be >= 0 and <= list size");
    }
  }

  private static <T> void checkListForDuplications(List<T> from) {
    Set<T> uniqueElements = new HashSet<>();

    for (T elem : from) {
      if (!uniqueElements.add(elem)) {
        throw new IllegalArgumentException(
            "The list must not have duplications.");
      }
    }
  }
}

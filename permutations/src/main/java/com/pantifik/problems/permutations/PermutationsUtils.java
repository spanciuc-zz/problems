package com.pantifik.problems.permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationsUtils {
  private PermutationsUtils() {
  }

  static <T> List<T> createPermutationAndFillWithNull(int count) {
    List<T> result = new ArrayList<>(count);
    for (int x = 0; x < count; x++) {
      result.add(null);
    }
    return result;
  }
}

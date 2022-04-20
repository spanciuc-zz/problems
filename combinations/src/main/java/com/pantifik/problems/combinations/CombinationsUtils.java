package com.pantifik.problems.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides utility resource.
 */
class CombinationsUtils {
  private CombinationsUtils() {}

  /**
   * Creates a list of null elements with specified size
   *
   * @param count
   *     the number of elements, must be positive number.
   * @param <T>
   *     the type of the elements in the list.
   * @return the newly created list.
   *
   * @throws IllegalArgumentException
   *     if number is negative.
   */
  public static <T> List<T> createAndFillWithNull(int count) {

    if (count < 0) {
      throw new IllegalArgumentException("The count must be positive number");
    }

    List<T> result = new ArrayList<>(2);
    for (int x = 0; x < count; x++) {
      result.add(null);
    }
    return result;
  }
}

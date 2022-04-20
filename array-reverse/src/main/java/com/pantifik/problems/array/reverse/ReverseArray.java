package com.pantifik.problems.array.reverse;

import com.pantifik.problems.array.utils.ArraySwap;

/**
 * Reverses the elements in the array.
 */
public final class ReverseArray {

  private ReverseArray() {
  }

  /**
   * Reverses the given array.
   * <p>
   * Complexity O(n/2) => O(n).
   * </p>
   *
   * @param arr
   *     - the array, must not be null.
   * @param <T>
   *     - the type of elements in the array.
   * @throws IllegalArgumentException
   *     if the array is null or empty.
   */
  public static <T> void reverse(final T[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array must not be null or empty");
    }

    int lastIndex = arr.length - 1;

    for (int i = 0; i < arr.length / 2; i++) {
      ArraySwap.swap(arr, i, lastIndex - i);
    }
  }
}

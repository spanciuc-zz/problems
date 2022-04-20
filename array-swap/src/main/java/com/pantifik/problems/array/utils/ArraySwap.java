package com.pantifik.problems.array.utils;

import java.util.Objects;

/**
 * Provides methods to swap the elements of an array.
 */
public class ArraySwap {

  private ArraySwap() {}

  /**
   * Swaps the elements of the array.
   *
   * @param array
   *     the actual array.
   * @param indexFrom
   *     the first index to swap must be in bounds of the array.
   * @param indexTo
   *     the second index to swap must be in bounds of the array.
   */
  public static void swap(Object[] array, int indexFrom, int indexTo) {

    Objects.requireNonNull(array);
    Objects.checkFromToIndex(indexFrom, indexTo, array.length);

    Object temp = array[indexTo];
    array[indexTo] = array[indexFrom];
    array[indexFrom] = temp;

  }

}

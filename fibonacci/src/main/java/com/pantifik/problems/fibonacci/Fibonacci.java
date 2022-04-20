package com.pantifik.problems.fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for working with Fibonacci sequence.
 */
public interface Fibonacci {

  /**
   * Generates the Fibonacci sequence.
   *
   * @param endIndex
   *     the number of the elements to generate, must be greater than or equal
   *     to 0.
   * @return the list of Fibonacci numbers.
   *
   * @throws IllegalArgumentException
   *     if index is less than 0.
   */
  default List<Integer> getSequence(int endIndex) {
    Validation.validatePositiveNumber(endIndex);
    return getSequence(0, endIndex);
  }

  /**
   * Generates the Fibonacci sequence in range.
   *
   * @param startIndex
   *     the start index of sequence, must be in range [0, endIndex].
   * @param endIndex
   *     the end index of sequence, must be >= startIndex.
   * @return the list of numbers from sequence that are in given range.
   *
   * @throws IllegalArgumentException
   *     if startIndex less than 0 or startIndex greater than endIndex.
   */
  default List<Integer> getSequence(int startIndex, int endIndex) {
    Validation.validatePositiveNumber(startIndex);
    Validation.validatePositiveNumber(endIndex);
    Validation.validateIndexesRange(startIndex, endIndex);
    List<Integer> sequence = new ArrayList<>();
    for (int x = startIndex; x < endIndex; x++) {
      sequence.add(valueAt(x));
    }
    return sequence;
  }

  /**
   * Checks if the given number is in Fibonacci sequence.
   *
   * @param number
   *     the number to check, must be >= 0.
   * @return true if number is in sequence, otherwise - false.
   *
   * @throws IllegalArgumentException
   *     if number less than 0.
   */
  default boolean isInSequence(int number) {
    Validation.validatePositiveNumber(number);
    return getIndex(number) > -1;
  }

  /**
   * Gets the index of the given number in Fibonacci sequence.
   *
   * @param number
   *     the number to find index of, must be > 0.
   * @return the index of the number if present, if not present return -1.
   *
   * @throws IllegalArgumentException
   *     if number < 0.
   */
  default int getIndex(int number) {
    Validation.validatePositiveNumber(number);

    int index = 0;
    int value = 0;
    while (value < number) {
      value = valueAt(++index);
    }

    return value == number ? index : -1;
  }

  /**
   * Gets the number at the given index in Fibonacci sequence.
   * <p>
   * Some paragraph.
   *
   * @param index
   *     the index to get, must be > 0.
   * @return the number at index.
   *
   * @throws IllegalArgumentException
   *     if index is less than 0.
   */
  int valueAt(int index);

}

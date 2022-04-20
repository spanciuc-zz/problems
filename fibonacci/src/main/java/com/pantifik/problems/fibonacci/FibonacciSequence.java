package com.pantifik.problems.fibonacci;

import java.util.List;

/**
 * Provides the useful methods for working with the Fibonacci sequence.
 */
public final class FibonacciSequence {

  /**
   * Default calculation type, used then one id not given.
   */
  public static final CalculationType DEFAULT_TYPE
      = CalculationType.RECURSIVE_MEMO;

  private FibonacciSequence() {}

  /**
   * Generates the Fibonacci sequence up to the index.
   * <p>
   * Uses the default calculation strategy, see {@link #DEFAULT_TYPE}
   *
   * @param endIndex
   *     the end index, must be >= 0.
   * @return the list of Fibonacci numbers.
   *
   * @throws IllegalArgumentException
   *     if index < 0.
   */
  public static List<Integer> getSequence(int endIndex) {
    return getSequence(endIndex, DEFAULT_TYPE);
  }

  /**
   * Generates the Fibonacci sequence up to the index.
   * <p>
   * Uses the given strategy, see {@link CalculationType}
   *
   * @param endIndex
   *     the end index, must be >= 0.
   * @param type
   *     the strategy to use, must not be null.
   * @return the list of Fibonacci numbers.
   *
   * @throws IllegalArgumentException
   *     if index < 0 or type is null.
   */
  public static List<Integer> getSequence(int endIndex, CalculationType type) {
    Validation.validateCalculationType(type);
    return type.getFibonacciGenerator()
        .getSequence(endIndex);
  }

  /**
   * Generates the Fibonacci sequence in range, using default strategy, see
   * {@link #DEFAULT_TYPE}.
   *
   * @param startIndex
   *     the lower bound of the range, must be >= 0.
   * @param endIndex
   *     the upper bound of the range, must be > startIndex.
   * @return the list of Fibonacci numbers.
   *
   * @throws IllegalArgumentException
   *     if startIndex or endIndex is invalid.
   */
  public static List<Integer> getSequence(int startIndex, int endIndex) {
    return getSequence(startIndex, endIndex, DEFAULT_TYPE);
  }

  /**
   * Generates the Fibonacci sequence in range, using given strategy, see {@link
   * #DEFAULT_TYPE}.
   *
   * @param startIndex
   *     the lower bound of the range, must be >= 0.
   * @param endIndex
   *     the upper bound of the range, must be > startIndex.
   * @param type
   *     the strategy to use, must not be null.
   * @return the list of Fibonacci numbers.
   *
   * @throws IllegalArgumentException
   *     if startIndex or endIndex is invalid, or type is null.
   */
  public static List<Integer> getSequence(int startIndex, int endIndex,
      CalculationType type) {
    Validation.validateCalculationType(type);
    return type.getFibonacciGenerator()
        .getSequence(startIndex, endIndex);
  }

  /**
   * Checks if a number is in Fibonacci sequence, using default strategy {@link
   * #DEFAULT_TYPE}.
   *
   * @param number
   *     the number to check, must be >= 0.
   * @return true if the number is in sequence, otherwise - false.
   *
   * @throws IllegalArgumentException
   *     if number is < -1.
   */
  public static boolean isInSequence(int number) {
    return isInSequence(number, DEFAULT_TYPE);
  }

  /**
   * Checks if a number is in Fibonacci sequence, using given strategy.
   *
   * @param number
   *     the number to check, must be >= 0.
   * @param type
   *     the strategy to use, must not be null.
   * @return true if the number is in sequence, otherwise - false.
   *
   * @throws IllegalArgumentException
   *     if number is < -1.
   */
  public static boolean isInSequence(int number, CalculationType type) {
    Validation.validateCalculationType(type);
    return type.getFibonacciGenerator()
        .isInSequence(number);
  }

  /**
   * Gets the index of a number in Fibonacci sequence, using default strategy
   * {@link #DEFAULT_TYPE}.
   *
   * @param number
   *     the number to check, must be > 0.
   * @return the index of the number if exists, otherwise returns -1.
   *
   * @throws IllegalArgumentException
   *     if the number is <  0.
   */
  public static int getIndex(int number) {
    return getIndex(number, DEFAULT_TYPE);
  }

  /**
   * Gets the index of a number in Fibonacci sequence.
   *
   * @param number
   *     the number to check, must be > 0.
   * @param type
   *     the strategy to use, must not be null.
   * @return the index of the number if exists, otherwise returns -1.
   *
   * @throws IllegalArgumentException
   *     if the number is <  0 or type is null.
   */
  public static int getIndex(int number, CalculationType type) {
    Validation.validateCalculationType(type);
    return type.getFibonacciGenerator()
        .getIndex(number);
  }

  /**
   * Gets the value at the given index in the Fibonacci sequence, using default
   * strategy {@link #DEFAULT_TYPE}.
   *
   * @param index
   *     the index to get the value at, must be >= 0.
   * @return the value at the index.
   *
   * @throws IllegalArgumentException
   *     if index < 0.
   */
  public static int valueAt(int index) {
    return valueAt(index, DEFAULT_TYPE);
  }

  /**
   * Gets the value at the given index in the Fibonacci sequence.
   *
   * @param index
   *     the index to get the value at, must be >= 0.
   * @param type
   *     the strategy to use, must not be null.
   * @return the value at the index.
   *
   * @throws IllegalArgumentException
   *     if index < 0 or type is null.
   */
  public static int valueAt(int index, CalculationType type) {
    Validation.validateCalculationType(type);
    return type.getFibonacciGenerator()
        .valueAt(index);
  }

}

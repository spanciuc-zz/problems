package com.pantifik.problems.fibonacci;

public class RecursiveFibonacci implements Fibonacci {

  /**
   * The first 2 elements of Fibonacci sequence.
   */
  protected static final int[] SEQUENCE_START = {0, 1};
  /**
   * The index of first number in the sequence.
   */
  protected static final int FIRST_INDEX = 0;
  /**
   * The index of the second number in sequence.
   */
  protected static final int SECOND_INDEX = 1;

  /**
   * {@inheritDoc}
   * <p>
   * The Complexity is O(2^n).
   * </p>
   */
  @Override
  public int valueAt(int index) {
    Validation.validatePositiveNumber(index);
    if (index == FIRST_INDEX) {
      return SEQUENCE_START[FIRST_INDEX];
    } else if (index == SECOND_INDEX) {
      return SEQUENCE_START[SECOND_INDEX];
    } else {
      return valueAt(index - 1) + valueAt(index - 2);
    }
  }

}

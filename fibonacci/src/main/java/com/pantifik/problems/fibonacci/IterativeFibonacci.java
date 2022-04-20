package com.pantifik.problems.fibonacci;

/**
 * The iterative Fibonacci sequence.
 */
class IterativeFibonacci implements Fibonacci {

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
   * The Complexity is O(n).
   * </p>
   */
  @Override
  public int valueAt(int index) {
    Validation.validatePositiveNumber(index);

    if (index == FIRST_INDEX) {
      return SEQUENCE_START[FIRST_INDEX];
    } else if (index == SECOND_INDEX) {
      return SEQUENCE_START[SECOND_INDEX];
    }

    int value = -1;
    int[] previous = new int[]{SEQUENCE_START[FIRST_INDEX],
        SEQUENCE_START[SECOND_INDEX]};
    for (int x = SEQUENCE_START.length; x <= index; x++) {
      value = calculateNext(previous);
      updatePrevious(value, previous);
    }
    return value;
  }

  protected static void updatePrevious(int nextValue, int[] previous) {
    previous[FIRST_INDEX] = previous[SECOND_INDEX];
    previous[SECOND_INDEX] = nextValue;
  }

  protected static int calculateNext(int[] previous) {
    return previous[FIRST_INDEX] + previous[SECOND_INDEX];
  }
}


package com.pantifik.problems.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class RecursiveMemoFibonacci extends RecursiveFibonacci {

  /**
   * {@inheritDoc}
   * <p>The complexity: O(n)</p>
   */
  @Override
  public List<Integer> getSequence(int startIndex, int endIndex) {
    Validation.validatePositiveNumber(startIndex);
    Validation.validatePositiveNumber(endIndex);
    Validation.validateIndexesRange(startIndex, endIndex);
    int[] memo = new int[endIndex];
    List<Integer> sequence = new ArrayList<>();
    for (int x = startIndex; x < endIndex; x++) {
      sequence.add(valueAtUsingMemo(x, memo));
    }
    return sequence;
  }

  private int valueAtUsingMemo(int index, int[] memo) {

    if (index == FIRST_INDEX) {
      return SEQUENCE_START[FIRST_INDEX];
    } else if (index == SECOND_INDEX) {
      return SEQUENCE_START[SECOND_INDEX];
    } else if (memo[index] > 0) {
      return memo[index];
    }

    memo[index] = valueAtUsingMemo(index - 1, memo) + valueAtUsingMemo(
        index - 2, memo);

    return memo[index];

  }
}

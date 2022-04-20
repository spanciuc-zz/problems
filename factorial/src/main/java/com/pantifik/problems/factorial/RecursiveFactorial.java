package com.pantifik.problems.factorial;

import java.math.BigInteger;

/**
 * Provides recursive factorial calculation.
 */
final class RecursiveFactorial {
  private RecursiveFactorial() {
  }

  /**
   * Calculates the factorial of a number.
   *
   * <p>Complexity O(n)</p>
   *
   * @param number the number to calculate factorial for, non-negative.
   * @return the factorial of the given number.
   */
  public static BigInteger calculate(final BigInteger number) {

    Validation.checkForNullAndNegative(number);

    return calculateHelper(BigInteger.ZERO, number);
  }

  /**
   * Calculates the factorial in a given range.
   * <p>
   * Complexity here.!!!!!!!!!!!!
   *
   * @param from the lower bound.
   * @param to   the upper bound.
   * @return the factorial in range.
   */
  public static BigInteger calculateInRange(final BigInteger from,
      final BigInteger to) {
    Validation.checkForNullAndNegative(from);
    Validation.checkForNullAndNegative(to);
    Validation.validateBounds(from, to);

    return calculateHelper(from.subtract(BigInteger.ONE), to);
  }

  private static BigInteger calculateHelper(final BigInteger stopCondition,
      final BigInteger number) {
    if (number.compareTo(stopCondition) == 0) {
      return BigInteger.ONE;
    }
    return number.multiply(calculateHelper(stopCondition, number.subtract(BigInteger.ONE)));
  }
}

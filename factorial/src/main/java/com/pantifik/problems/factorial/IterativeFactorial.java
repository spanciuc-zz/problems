package com.pantifik.problems.factorial;

import java.math.BigInteger;

/**
 * Provides iterative factorial calculation.
 */
final class IterativeFactorial {
  private IterativeFactorial() {
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

    if (number.compareTo(BigInteger.ZERO) == 0) {
      return BigInteger.ONE;
    }

    return calculateHelper(BigInteger.ONE, number);

  }

  public static BigInteger calculateInRange(final BigInteger from,
      final BigInteger to) {

    Validation.checkForNullAndNegative(from);
    Validation.checkForNullAndNegative(to);
    Validation.validateBounds(from, to);

    return calculateHelper(from.subtract(BigInteger.ONE), to);
  }

  private static BigInteger calculateHelper(BigInteger stopCondition,
      BigInteger number) {
    BigInteger result = BigInteger.ONE;
    for (BigInteger i = number; i.compareTo(stopCondition) > 0;
         i = i.subtract(BigInteger.ONE)) {
      result = result.multiply(i);
    }
    return result;
  }
}

package com.pantifik.problems.factorial;

import java.math.BigInteger;

/**
 * Provides recursive methods to check whether a number is factorial value of
 * another number.
 */
final class RecursiveFactorialCheck {

  private RecursiveFactorialCheck() {
  }

  /**
   * Checks if the given number is factorial value.
   *
   * @param number the number to check, must be positive number.
   * @return true if it is factorial, otherwise false.
   */
  public static boolean test(final BigInteger number) {

    Validation.checkForNullAndNegative(number);

    if (number.compareTo(BigInteger.ZERO) == 0) {
      throw new IllegalArgumentException("The number must be positive");
    }

    if (number.compareTo(BigInteger.ONE) == 0) {
      return true;
    }
    BigInteger num = checkIsFactorial(number, BigInteger.TWO);
    return num.compareTo(BigInteger.ONE) == 0;
  }

  private static BigInteger checkIsFactorial(final BigInteger number,
      final BigInteger divisor) {

    if (number.mod(divisor)
        .compareTo(BigInteger.ZERO) != 0) {
      return number;
    }

    return checkIsFactorial(number.divide(divisor),
        divisor.add(BigInteger.ONE));
  }

}

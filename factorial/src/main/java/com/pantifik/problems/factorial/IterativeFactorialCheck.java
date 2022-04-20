package com.pantifik.problems.factorial;

import java.math.BigInteger;

/**
 * Provides iterative methods to check whether a number is factorial value of
 * another number.
 */
final class IterativeFactorialCheck {
  private IterativeFactorialCheck() {
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

    BigInteger num = number;

    for (BigInteger i = BigInteger.TWO; ; i = i.add(BigInteger.ONE)) {
      BigInteger mod = num.mod(i);
      if (mod.compareTo(BigInteger.ZERO) == 0) {
        num = num.divide(i);
      } else {
        break;
      }
    }

    return num.compareTo(BigInteger.ONE) == 0;

  }

}

package com.pantifik.problems.factorial;

import java.math.BigInteger;

class Validation {

  private Validation() {}

  public static void checkForNullAndNegative(final BigInteger number) {
    if (number == null) {
      throw new IllegalArgumentException("The number must not be null");
    }

    if (number.compareTo(BigInteger.ZERO) < 0) {
      throw new IllegalArgumentException("The number must be non-negative");
    }
  }

  static void validateBounds(final BigInteger from, final BigInteger to) {

    if (from.compareTo(to) > 0) {
      throw new IllegalArgumentException(
          "The 'from' number must be less than 'to' number");
    }

  }
}

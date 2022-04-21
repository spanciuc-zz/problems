package com.pantifik.problems.powersof;

/**
 * Provides useful validation methods.
 */
final class Validation {

  private Validation() {}

  /**
   * Checks if a number is greater than 1.
   *
   * @param number
   *     the number to check.
   * @throws IllegalArgumentException
   *     if number is less than 1.
   */
  static void validateIntegerGreaterThan0(int number) {
    if (number < 1) {
      throw new IllegalArgumentException("The number must be > 0");
    }
  }

  /**
   * Checks if a number is greater than 0.
   *
   * @param power
   *     the number to check.
   * @throws IllegalArgumentException
   *     if number is less than 0.
   */
  static void validateIntegerGreaterThanOrEqualsTo0(int power) {
    if (power < 0) {
      throw new IllegalArgumentException("The power must be >= 0");
    }
  }

  /**
   * Checks if the given parameter is not null.
   *
   * @param target
   *     the parameter to check.
   * @throws IllegalArgumentException
   *     if parameter is null.
   */
  static <T> void validateNotNull(T target) {
    if (target == null) {
      throw new IllegalArgumentException("The parameter must not be null");
    }
  }
}

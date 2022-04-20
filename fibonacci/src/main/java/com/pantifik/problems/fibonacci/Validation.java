package com.pantifik.problems.fibonacci;

/**
 * Provides useful validation methods.
 */
class Validation {

  private Validation() {}

  static void validatePositiveNumber(int number) {
    if (number < 0) {
      throw new IllegalArgumentException("The number must be positive");
    }
  }

  static void validateIndexesRange(int startIndex, int endIndex) {
    if (startIndex > endIndex) {
      throw new IllegalArgumentException(
          "The start index must be less than end index");
    }
  }

  static void validateCalculationType(CalculationType type) {
    if (type == null) {
      throw new IllegalArgumentException("The type must not be null");
    }
  }
}

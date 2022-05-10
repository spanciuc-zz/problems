package com.pantifik.problems.bitwise;

/**
 * A class that provides methods to add 1 to a given number without using + sign.
 */
public class OneAdditionToNumber {

  private OneAdditionToNumber() {
  }

  /**
   * Adds 1 to the number.
   * <p>
   * Uses bitwise operations.
   *
   * @param number
   *     the number.
   * @return the number plus one.
   */
  public static int addOne(int number) {
    int result = number;
    int rightMost0 = 1;
    while ((result & rightMost0) > 0) {
      result = result ^ rightMost0;
      rightMost0 = rightMost0 << 1;
    }
    return result ^ rightMost0;
  }
}

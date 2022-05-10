package com.pantifik.problems.bitwise;

/**
 * A class that that provides methods to check if two integers have opposite signs.
 */
public class IntegersOppositeSign {

  private IntegersOppositeSign() {
  }

  /**
   * Checks if the giben integers have opposite signs.
   * <p>
   * Uses bitwise operations.
   *
   * @param a
   *     the first integer.
   * @param b
   *     the second integer
   * @return true if the integers have opposite signs, otherwise - false.
   */
  public static boolean check(int a, int b) {
    return (a ^ b) < 0;
  }

}

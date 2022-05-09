package com.pantifik.problems.bitwise;

/**
 * A class that provides methods for integer additions without using + sign.
 */
public class Addition {

  private Addition() {}

  /**
   * Adds two integers iteratively, without using + sign.
   * <p>
   * Uses bitwise operations instead.
   *
   * @param a
   *     the first integer.
   * @param b
   *     the second integer.
   * @return addition result.
   */
  public static int iterativeAddition(int a, int b) {

    int result = a;
    int toAdd = b;
    while (toAdd != 0) {
      int carry = result & toAdd;
      result = result ^ toAdd;
      toAdd = carry << 1;
    }
    return result;
  }

  /**
   * Adds two integers recursively, without using + sign.
   * <p>
   * Uses bitwise operations instead.
   *
   * @param a
   *     the first integer.
   * @param b
   *     the second integer.
   * @return addition result.
   */
  public static int recursiveAddition(int a, int b) {
    int result = a;
    int toAdd = b;
    return recursiveAdditionHelper(result, toAdd);
  }

  private static int recursiveAdditionHelper(int result, int toAdd) {
    if (toAdd == 0) {
      return result;
    }
    int carry = result & toAdd;
    result = result ^ toAdd;
    toAdd = carry << 1;
    return recursiveAddition(result, toAdd);
  }

}

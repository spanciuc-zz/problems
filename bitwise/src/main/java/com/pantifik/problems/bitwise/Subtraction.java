package com.pantifik.problems.bitwise;

/**
 * A class that provides methods for integer additions without using - sign.
 */
public class Subtraction {

  private Subtraction() {
  }

  /**
   * Subtracts two integers iteratively, without using - sign.
   * <p>
   * Uses bitwise operations instead.
   *
   * @param a
   *     the number to subtract from.
   * @param b
   *     the number to subtract.
   * @return subtraction result.
   */
  public static int iterativeSubtraction(int a, int b) {
    int result = a;
    int toSubtract = b;
    while (toSubtract != 0) {
      int borrow = (~result) & toSubtract;
      result = result ^ toSubtract;
      toSubtract = borrow << 1;
    }
    return result;
  }

  /**
   * Subtracts two integers recursively, without using - sign.
   * <p>
   * Uses bitwise operations instead.
   *
   * @param a
   *     the number to subtract from.
   * @param b
   *     the number to subtract.
   * @return subtraction result.
   */
  public static int recursiveSubtraction(int a, int b) {
    int result = a;
    int toSubtract = b;
    return recursiveSubtractionHelper(result, toSubtract);
  }

  private static int recursiveSubtractionHelper(int result, int toSubtract) {

    if (toSubtract == 0) {
      return result;
    }
    int borrow = (~result) & toSubtract;
    result = result ^ toSubtract;
    toSubtract = borrow << 1;
    return recursiveSubtractionHelper(result, toSubtract);
  }

}

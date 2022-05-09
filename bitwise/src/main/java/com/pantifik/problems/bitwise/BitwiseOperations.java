package com.pantifik.problems.bitwise;

/**
 * A class that provides bitwise operations methods.
 */
public class BitwiseOperations {

  private BitwiseOperations() {}

  /**
   * Performs the logical AND(&) operation for 2 integers.
   * <p>
   * Ex:
   * <pre>
   * 0110
   * 0101
   * -----
   * 0100
   * </pre>
   *
   * @param a
   *     the first integers.
   * @param b
   *     the first integers.
   * @return the result of a & b.
   */
  public static int and(int a, int b) {
    return a & b;
  }

  /**
   * Performs the logical OR(|) operation for 2 integers.
   * <p>
   * EX:
   * <pre>
   * 0110
   * 0101
   * -----
   * 0111
   * </pre>
   *
   * @param a
   *     the first integer.
   * @param b
   *     the second integer.
   * @return the result of a | b.
   */
  public static int or(int a, int b) {
    return a | b;
  }

  /**
   * Performs the logical XOR(^) operation for 2 integers.
   * <p>
   * Stands for exclusive or. EX
   * <pre>
   * 0110
   * 0101
   * -----
   * 0011
   * </pre>
   *
   * @param a
   *     the first integer
   * @param b
   *     the second integer
   * @return the result of a ^ b.
   */
  public static int xor(int a, int b) {
    return a ^ b;
  }

  /**
   * Performs the logical NOT(~) operation for an integer.
   * <p>
   * This is named Complement operator, simply means the negation of each bit.
   *
   * @param a
   *     the integer.
   * @return the result of ~a.
   */
  public static int not(int a) {
    return ~a;
  }

  /**
   * Performs the right shift (>>) operation with given integers.
   * <p>
   * When an input number is negative, where the leftmost bit is 1, then the empty spaces will be
   * filled with 1.
   * <p>
   * When an input number is positive, where the leftmost bit is 0, then the empty spaces will be
   * filled with 0.
   * <p>
   * Ex:
   * <pre>
   *   0011 >> 1 = 0001
   * </pre>
   *
   * @param a
   *     the number to shift.
   * @param b
   *     the number of shifts.
   * @return the result of a >> b.
   */
  public static int rightShift(int a, int b) {
    return a >> b;
  }

  /**
   * Performs the left shift (<<) operation with given integers.
   * <p>
   * After the left shift, the empty space in the right is filled with 0.
   * <p>
   * Ex:
   * <pre>
   *   0011 << 1 = 0110
   * </pre>
   *
   * @param a
   *     the number to shift.
   * @param b
   *     the number of shifts.
   * @return the result of a >> b.
   */
  public static int leftShift(int a, int b) {
    return a << b;
  }

  /**
   * Performs the unsigned right shift (>>>) operation with given integers.
   * <p>
   * This operator is very similar to the signed right shift operator. The only difference is that
   * the empty spaces in the left are filled with 0 irrespective of whether the number is positive
   * or negative. Therefore, the result will always be a positive integer. Ex:
   * <pre>
   *   0011 >> 1 = 0001
   * </pre>
   *
   * @param a
   *     the number to shift.
   * @param b
   *     the number of shifts.
   * @return the result of a >>> b.
   */
  public static int unsignedRightShift(int a, int b) {
    return a >>> b;
  }

}

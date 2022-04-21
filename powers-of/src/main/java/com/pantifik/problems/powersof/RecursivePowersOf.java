package com.pantifik.problems.powersof;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Defines methods for recursively calculate the powers of a number.
 */
final class RecursivePowersOf {

  private RecursivePowersOf() {
  }

  /**
   * Recursively calculates powers of a number.
   *
   * <p>The complexity is : "log in base 'power' from 'number'"</p>
   *
   * @param number
   *     the upper bound, must be greater than 0.
   * @param power
   *     the power to calculate, must be greater than or equal to 0.
   * @return a list of powers values.
   *
   * @throws IllegalArgumentException
   *     if number is less than 1 or power is less than 0.
   */
  public static List<Integer> get(int number, int power) {
    Validation.validateIntegerGreaterThan0(number);
    Validation.validateIntegerGreaterThanOrEqualsTo0(power);

    if (power == 0) {
      return List.of(1);
    }

    if (power == 1) {
      return IntStream.rangeClosed(1, number)
          .boxed()
          .toList();
    }

    List<Integer> powersOf = new ArrayList<>();
    powersOfHelper(number, power, powersOf);
    return powersOf;
  }

  private static int powersOfHelper(int number, int power,
      List<Integer> powersOf) {
    if (number < power) {
      powersOf.add(1);
      return 1;
    } else {
      int previous = powersOfHelper(number / power, power, powersOf);
      int current = previous * power;
      powersOf.add(current);
      return current;
    }
  }
}

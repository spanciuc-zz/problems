package com.pantifik.problems.powersof;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Defines methods for calculation the powers of a numbers.
 */
final class IterativePowersOf {

  private IterativePowersOf() {}

  /**
   * Iteratively calculates powers of a number.
   *
   * <p>The complexity is: </p>
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

    int value = 1;
    while (value <= number) {
      powersOf.add(value);
      value *= power;
    }

    return powersOf;
  }

}

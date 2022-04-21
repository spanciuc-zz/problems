package com.pantifik.problems.powersof;

import java.util.List;
import java.util.function.BiFunction;

/**
 * Provides methods for calculating the powers of a number.
 */
public class PowersOf {

  /**
   * The default strategy, used when one is not given.
   */
  public static final Strategy DEFAULT_STRATEGY = Strategy.RECURSIVE;

  private PowersOf() {}

  /**
   * Calculates the power of a number, using default strategy, see {@link
   * #DEFAULT_STRATEGY}.
   *
   * @param number
   *     the upper bound, must be greater than 0.
   * @param power
   *     the power to calculate, must be greater than or equal to 0.
   * @return the list of powers.
   *
   * @throws IllegalArgumentException
   *     if number is less than 1 or power is less than 0.
   */
  public static List<Integer> get(int number, int power) {
    return get(number, power, DEFAULT_STRATEGY);
  }

  /**
   * Calculates the power of a number, using the given strategy.
   *
   * @param number
   *     the upper bound, must be greater than 0.
   * @param power
   *     the power to calculate, must be greater than or equal to 0.
   * @param strategy
   *     the strategy for calculation, must not be null.
   * @return the list of powers.
   *
   * @throws IllegalArgumentException
   *     if number is less than 1,  power is less than 0, or strategy is null.
   */
  public static List<Integer> get(int number, int power, Strategy strategy) {
    Validation.validateNotNull(strategy);
    return strategy.get(number, power);
  }

  /**
   * Defines the strategies for powers of calculation.
   */
  public enum Strategy {
    /**
     * Uses iteration.
     */
    ITERATIVE(IterativePowersOf::get),
    /**
     * Uses recursion.
     */
    RECURSIVE(RecursivePowersOf::get);

    private final BiFunction<Integer, Integer, List<Integer>> powersCalculator;

    /**
     * Creates the strategy with the method of calculation.
     *
     * @param powersCalculator
     *     the method used for calculation, must not be null.
     */
    Strategy(BiFunction<Integer, Integer, List<Integer>> powersCalculator) {
      this.powersCalculator = powersCalculator;
    }

    List<Integer> get(int number, int power) {
      return this.powersCalculator.apply(number, power);
    }

  }
}

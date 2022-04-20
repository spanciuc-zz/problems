package com.pantifik.problems.factorial;

import java.math.BigInteger;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Provides methods for factorial-related operations.
 */
public final class Factorial {

  /**
   * The default strategy used when one is not given.
   */
  static Strategy defaultStrategy = Strategy.RECURSIVE;

  private Factorial() {
  }

  /**
   * Calculates the factorial of the given number.
   *
   * @param number the number.
   * @return the factorial value.
   */
  public static BigInteger calculate(final int number) {
    return defaultStrategy.calculate(number);
  }

  /**
   * Calculates the factorial of the given number.
   *
   * @param number   the number.
   * @param strategy the strategy to be used.
   * @return the factorial value.
   */
  public static BigInteger calculate(final int number,
      final Strategy strategy) {
    return strategy.calculate(number);
  }

  /**
   * Calculates the factorial in range using default strategy.
   * <p>
   * Ex: calculate(10, 13) will return 10 * 11 * 12 * 13.
   *
   * @param from     the lower bound.
   * @param to       the upper bound.
   * @return the factorial value.
   */
  public static BigInteger calculate(final int from, final int to) {
    return defaultStrategy.calculateInRange(from, to);
  }

  /**
   * Calculates the factorial in range.
   * <p>
   * Ex: calculate(10, 13) will return 10 * 11 * 12 * 13.
   *
   * @param from     the lower bound.
   * @param to       the upper bound.
   * @param strategy the strategy to be used.
   * @return the factorial value.
   */
  public static BigInteger calculate(final int from, final int to,
      final Strategy strategy) {
    return strategy.calculateInRange(from, to);
  }

  /**
   * Checks if the given number is factorial value of another.
   *
   * @param number the number to check.
   * @return true if it is factorial, otherwise false.
   */
  public static boolean isFactorial(final BigInteger number) {
    return defaultStrategy.isFactorial(number);
  }

  /**
   * Checks if the given number is factorial value of another.
   *
   * @param number   the number to check.
   * @param strategy the strategy to be used.
   * @return true if it is factorial, otherwise false.
   */
  public static boolean isFactorial(final BigInteger number,
      final Strategy strategy) {
    return strategy.isFactorial(number);
  }

  /**
   * Defines strategy for factorial operations.
   */
  public enum Strategy {
    RECURSIVE(RecursiveFactorial::calculate,
        RecursiveFactorial::calculateInRange, RecursiveFactorialCheck::test),
    ITERATIVE(IterativeFactorial::calculate,
        IterativeFactorial::calculateInRange, IterativeFactorialCheck::test);

    private final UnaryOperator<BigInteger> calculator;

    private final BinaryOperator<BigInteger> rangeCalculator;

    private final Predicate<BigInteger> factorialChecker;

    Strategy(final UnaryOperator<BigInteger> calculator,
        BinaryOperator<BigInteger> rangeCalculator,
        final Predicate<BigInteger> isFactorial) {
      this.calculator = calculator;
      this.rangeCalculator = rangeCalculator;
      this.factorialChecker = isFactorial;
    }

    BigInteger calculate(int number) {
      return this.calculator.apply(BigInteger.valueOf(number));
    }

    BigInteger calculateInRange(int from, int to) {
      return this.rangeCalculator.apply(BigInteger.valueOf(from),
          BigInteger.valueOf(to));
    }

    boolean isFactorial(BigInteger number) {
      return this.factorialChecker.test(number);
    }

  }

}

package com.pantifik.problems.fibonacci;

import java.util.function.Supplier;

/**
 * Defines the different type of Fibonacci sequence generations.
 */
public enum CalculationType {
  /**
   * Uses the math formulas.
   */
  FORMULA(FormulaFibonacci::new),
  /**
   * Uses iterative approach.
   */
  ITERATIVE(IterativeFibonacci::new),
  /**
   * Uses recursive approach.
   */
  RECURSIVE(RecursiveFibonacci::new),
  /**
   * Uses recursive approach, with memoization.
   */
  RECURSIVE_MEMO(RecursiveMemoFibonacci::new);

  /**
   * Fibonacci generator supplier.
   */
  private final Supplier<Fibonacci> fibonacciSupplier;

  CalculationType(Supplier<Fibonacci> fibonacciSupplier) {
    this.fibonacciSupplier = fibonacciSupplier;
  }

  /**
   * Gets the Fibonacci generator defined for this type.
   *
   * @return the Fibonacci generator.
   */
  Fibonacci getFibonacciGenerator() {
    return fibonacciSupplier.get();
  }

}

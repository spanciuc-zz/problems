package com.pantifik.problems.fibonacci;

public class FormulaFibonacci implements Fibonacci {

  /**
   * The Golden Ratio.
   */
  private static final double PHI = 1.61803398875;

  /**
   * {@inheritDoc}
   * <p>
   * The index is calculated by formula.
   */
  @Override
  public int getIndex(int number) {
    Validation.validatePositiveNumber(number);
    int index = (int) Math.round(2.078087 * Math.log(number) + 1.672276);
    return valueAt(index) == number ? index : -1;
  }

  /**
   * {@inheritDoc}
   * <p>
   * The value is calculated by the formula: ((PHI)^n - (1 - PHI)^n) / sqrt(5),
   * where n is the index of the number to be calculated.
   * <p> The complexity is O(1).
   */
  @Override
  public int valueAt(int index) {
    Validation.validatePositiveNumber(index);
    return (int) ((Math.pow(PHI, index) - Math.pow((1 - PHI), index))
        / Math.sqrt(5));
  }
}

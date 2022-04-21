package com.pantifik.problems.pascals_triangle;

import com.pantifik.problems.factorial.Factorial;

public final class PascalsTriangleUsingCombinationsFormula {

  private PascalsTriangleUsingCombinationsFormula() {}

  public static void print(int lines) {
    if (lines < 1) {
      throw new IllegalArgumentException(
          "The number of lines must be greater than 0");
    }

    for (int line = 0; line < lines; line++) {
      printSpaceBefore(lines, line);
      printValues(line);
      printLine();
    }
  }

  private static void printLine() {
    System.out.println();
  }

  private static void printValues(int line) {
    for (int i = 0; i <= line; i++) {
      printValue(calculateValue(line, i));
    }
  }

  private static int calculateValue(int line, int index) {
    return Factorial.calculate(line)
        .divide(Factorial.calculate(line - index)
            .multiply(Factorial.calculate(index)))
        .intValue();
  }

  private static int factorial(int number) {
    if (number == 0) {
      return 1;
    } else {
      return number * factorial(number - 1);
    }
  }

  private static void printValue(int value) {
    System.out.print(value);
    printSpace();
  }

  private static void printSpaceBefore(int lines, int line) {
    for (int i = 0; i < lines - line; line++) {
      printSpace();
    }
  }

  private static void printSpace() {
    System.out.print(" ");
  }
}

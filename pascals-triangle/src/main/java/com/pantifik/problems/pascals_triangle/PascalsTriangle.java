package com.pantifik.problems.pascals_triangle;

public final class PascalsTriangle {

  public static final String SPACE = " ";

  private PascalsTriangle() {}

  public static void print(int lines) {

    if (lines < 1) {
      throw new IllegalArgumentException(
          "The number of lines must be greater than 0");
    }

    doPrint(lines);

  }

  private static void doPrint(int lines) {

    for (int line = 1; line <= lines; line++) {
      printSpaceBefore(lines, line);
      printValuesForLine(line);
      printLine();
    }

  }

  private static void printValuesForLine(int line) {
    int value = 1;
    for (int x = 1; x <= line; x++) {
      printValue(value);
      value = calculateNextValue(value, line, x);
    }
  }

  private static int calculateNextValue(int value, int line, int index) {
    return value * (line - index) / index;
  }

  private static void printValue(int value) {
    System.out.print(value);
    printSpace();
  }

  private static void printSpaceBefore(int lines, int line) {
    for (int s = 1; s <= lines - line; s++) {
      printSpace();
    }
  }

  private static void printSpace() {
    System.out.print(SPACE);
  }

  private static void printLine() {
    System.out.println();
  }

}

package com.pantifik.problems.pascals_triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PascalTriangleUsingCombinationsTest {

  @ParameterizedTest
  @ValueSource(ints = {-100, -1, 0})
  void print_whenLinesLessThanOne_shouldThrowException(int lines) {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> PascalsTriangleUsingCombinationsFormula.print(lines));
  }

}
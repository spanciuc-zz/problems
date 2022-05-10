package com.pantifik.problems.bitwise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OneAdditionToNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {Integer.MAX_VALUE, Integer.MAX_VALUE, -10, -5, -1, 0, 1, 3, 7, 10})
  void name(int number) {
    assertEquals(number + 1, OneAdditionToNumber.addOne(number));
  }
}
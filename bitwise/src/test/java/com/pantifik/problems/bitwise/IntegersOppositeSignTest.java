package com.pantifik.problems.bitwise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntegersOppositeSignTest {

  public static Stream<Arguments> checkProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(false, 0, 0));
    arguments.add(Arguments.of(false, -1, -1));
    arguments.add(Arguments.of(false, 10, 200));
    arguments.add(Arguments.of(true, 1, -1));
    arguments.add(Arguments.of(true, Integer.MIN_VALUE, Integer.MAX_VALUE));
    return arguments.stream();
  }

  @ParameterizedTest
  @MethodSource("checkProvider")
  void check_shouldReturnCorrectCheckResult(boolean expected, int a, int b) {
    assertEquals(expected, IntegersOppositeSign.check(a, b));
  }

}
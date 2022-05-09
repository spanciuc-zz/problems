package com.pantifik.problems.bitwise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AdditionTest {

  public static Stream<Arguments> addProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(0, 0, 0));
    arguments.add(Arguments.of(0, 1, -1));
    arguments.add(Arguments.of(1, 0, 1));
    arguments.add(Arguments.of(5, 3, 2));
    arguments.add(Arguments.of(1, 3, -2));
    arguments.add(Arguments.of(-35, -33, -2));
    arguments.add(Arguments.of(-22, 32, -54));
    arguments.add(Arguments.of(1168, 123, 1045));
    arguments.add(Arguments.of(Integer.MIN_VALUE, Integer.MAX_VALUE, 1));
    return arguments.stream();
  }

  @ParameterizedTest
  @MethodSource("addProvider")
  void iterativeAddition_shouldReturnSumOfTwoIntegers(int expected, int a, int b) {
    assertEquals(expected, Addition.iterativeAddition(a, b));
  }

  @ParameterizedTest
  @MethodSource("addProvider")
  void recursiveAddition_shouldReturnSumOfTwoIntegers(int expected, int a, int b) {
    assertEquals(expected, Addition.recursiveAddition(a, b));
  }
}
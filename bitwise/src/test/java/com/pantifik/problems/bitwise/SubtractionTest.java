package com.pantifik.problems.bitwise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SubtractionTest {

  public static Stream<Arguments> subtractProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(0, 0, 0));
    arguments.add(Arguments.of(0, 1, 1));
    arguments.add(Arguments.of(1, 2, 1));
    arguments.add(Arguments.of(1, 3, 2));
    arguments.add(Arguments.of(5, 7, 2));
    arguments.add(Arguments.of(31, 33, 2));
    arguments.add(Arguments.of(28, 32, 4));
    arguments.add(Arguments.of(-7, -10, -3));
    arguments.add(Arguments.of(7, 10, 3));
    arguments.add(Arguments.of(13, 10, -3));
    arguments.add(Arguments.of(Integer.MAX_VALUE - 1, Integer.MAX_VALUE, 1));
    return arguments.stream();
  }

  @ParameterizedTest
  @MethodSource("subtractProvider")
  void iterativeAddition_shouldReturnSumOfTwoIntegers(int expected, int a, int b) {
    assertEquals(expected, Subtraction.iterativeSubtraction(a, b));
  }

  @ParameterizedTest
  @MethodSource("subtractProvider")
  void recursiveAddition_shouldReturnSumOfTwoIntegers(int expected, int a, int b) {
    assertEquals(expected, Subtraction.recursiveSubtraction(a, b));
  }

}
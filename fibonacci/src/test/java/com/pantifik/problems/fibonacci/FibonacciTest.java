package com.pantifik.problems.fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public abstract class FibonacciTest {

  protected Fibonacci fibonacci;

  @BeforeEach
  protected abstract void setUp();

  @ParameterizedTest
  @MethodSource("getSequenceOnlyEndIndexProvider")
  void getSequence_whenEndIndexIsValidIndex_shouldReturnFibonacciSequence(
      int endIndex, List<Integer> expected) {
    assertEquals(expected, fibonacci.getSequence(endIndex));
  }

  @ParameterizedTest
  @MethodSource("getSequenceStartAndEndIndexProvider")
  void getSequence_whenStartAndEndIndexIsValid_shouldReturnFibonacciSequence(
      int startIndex, int endIndex, List<Integer> expected) {
    assertEquals(expected, fibonacci.getSequence(startIndex, endIndex));
  }

  @ParameterizedTest
  @CsvSource(
      {"0,0", "1,1", "2,1", "3,2", "4,3", "5,5", "6,8", "7,13", "8,21", "9,34",
          "10,55", "11,89", "14,377"})
  void valueAt_whenValidIndex_shouldReturnFibonacciSequence(int index,
      int expected) {
    assertEquals(expected, fibonacci.valueAt(index));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3, 5, 8, 13, 21, 34})
  void isInSequence_whenIsFibonacciNumber_shouldReturnTrue(int number) {
    assertTrue(fibonacci.isInSequence(number));
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 7, 9, 1000})
  void isInSequence_whenIsNotFibonacciNumber_shouldReturnFalse(int number) {
    assertFalse(fibonacci.isInSequence(number));
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 7, 9, 1000})
  void getIndex_whenIsNotFibonacciNumber_shouldReturnNegative1(int number) {
    assertEquals(-1, fibonacci.getIndex(number));
  }

  @ParameterizedTest
  @CsvSource(
      {"0, 0", "3, 2", "4, 3", "5, 5", "6, 8", "7, 13", "8, 21", "9, 34"})
  void getIndex_whenIsFibonacciNumber_shouldReturnIndex(int expected,
      int number) {
    assertEquals(expected, fibonacci.getIndex(number));
  }

  private static Stream<Arguments> getSequenceOnlyEndIndexProvider() {
    return Stream.of(Arguments.of(0, List.of()), Arguments.of(1, List.of(0)),
        Arguments.of(2, List.of(0, 1)),
        Arguments.of(12, List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)));
  }

  private static Stream<Arguments> getSequenceStartAndEndIndexProvider() {
    return Stream.of(Arguments.of(0, 0, List.of()),
        Arguments.of(0, 1, List.of(0)), Arguments.of(0, 2, List.of(0, 1)),
        Arguments.of(0, 3, List.of(0, 1, 1)), Arguments.of(1, 2, List.of(1)),
        Arguments.of(1, 3, List.of(1, 1)), Arguments.of(2, 3, List.of(1)),
        Arguments.of(0, 12, List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)),
        Arguments.of(5, 5, List.of()), Arguments.of(5, 6, List.of(5)),
        Arguments.of(5, 10, List.of(5, 8, 13, 21, 34)));
  }

}

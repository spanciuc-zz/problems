package com.pantifik.problems.fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class FibonacciSequenceTest {

  @Test
  void getSequence_whenEndIndexIsNegative_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.getSequence(-1));
  }

  @Test
  void getSequence_whenEndIndexAndTypeIsNull_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.getSequence(0, null));
  }

  @Test
  void getSequence_whenEndIndexAndTypeIsNotGiven_shouldUseDefaultType() {
    int endIndex = 5;
    List<Integer> expected = FibonacciSequence.getSequence(endIndex,
        FibonacciSequence.DEFAULT_TYPE);
    List<Integer> actual = FibonacciSequence.getSequence(endIndex);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(CalculationType.class)
  void getSequence_whenEndIndexAndTypeIsGiven_shouldUseGivenType(
      CalculationType type) {
    int endIndex = 5;
    List<Integer> expected = type.getFibonacciGenerator()
        .getSequence(endIndex);
    List<Integer> actual = FibonacciSequence.getSequence(endIndex, type);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(CalculationType.class)
  void getSequence_whenEndIndexAndTypeIsGiven_shouldReturnSameResultForAllTypes(
      CalculationType type) {
    int endIndex = 12;
    List<Integer> expected = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);
    List<Integer> actual = FibonacciSequence.getSequence(endIndex, type);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({"-1, 0", "0, -1", "-1, -1"})
  void getSequence_whenStartOrEndIndexIsNegative_shouldThrowException(
      int startIndex, int endIndex) {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.getSequence(startIndex, endIndex));
  }

  @Test
  void getSequence_whenEndIndexIsGreaterThanStartIndex_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.getSequence(4, 3));
  }

  @Test
  void getSequence_whenStartAndEndIndexAndTypeIsNull_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.getSequence(0, 0, null));
  }

  @Test
  void getSequence_whenStartAndEndIndexAndTypeIsNotGiven_shouldUseDefaultType() {
    int startIndex = 2;
    int endIndex = 5;
    List<Integer> expected = FibonacciSequence.getSequence(startIndex, endIndex,
        FibonacciSequence.DEFAULT_TYPE);
    List<Integer> actual = FibonacciSequence.getSequence(startIndex, endIndex);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(CalculationType.class)
  void getSequence_whenStartAndEndIndexAndTypeIsGiven_shouldReturnSameResultForAllTypes(
      CalculationType type) {
    int startIndex = 2;
    int endIndex = 12;
    List<Integer> expected = List.of(1, 2, 3, 5, 8, 13, 21, 34, 55, 89);
    List<Integer> actual = FibonacciSequence.getSequence(startIndex, endIndex,
        type);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(CalculationType.class)
  void getSequence_whenStartAndEndIndexAndTypeIsGiven_shouldUseGivenType(
      CalculationType type) {
    int startIndex = 0;
    int endIndex = 5;
    List<Integer> expected = type.getFibonacciGenerator()
        .getSequence(startIndex, endIndex);
    List<Integer> actual = FibonacciSequence.getSequence(startIndex, endIndex,
        type);
    assertEquals(expected, actual);
  }

  @Test
  void valueAt_whenIndexIsNegative_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.valueAt(-1));
  }

  @Test
  void valueAt_whenTypeIsNull_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.valueAt(1, null));
  }

  @Test
  void valueAt_whenTypeIsNotGiven_shouldUseDefaultType() {
    int index = 7;
    int expected = FibonacciSequence.valueAt(index,
        FibonacciSequence.DEFAULT_TYPE);
    int actual = FibonacciSequence.valueAt(index);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(CalculationType.class)
  void valueAt_whenTypeIsGiven_shouldUseGivenType(CalculationType type) {
    int index = 10;
    int expected = type.getFibonacciGenerator()
        .valueAt(index);
    int actual = FibonacciSequence.valueAt(index, type);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(CalculationType.class)
  void valueAt_whenTypeIsGiven_shouldReturnSameResultForAllTypes(
      CalculationType type) {
    int index = 10;
    int expected = 55;
    int actual = FibonacciSequence.valueAt(index, type);
    assertEquals(expected, actual);
  }

  @Test
  void isInSequence_whenNegativeNumber_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.isInSequence(-1));
  }

  @Test
  void isInSequence_whenTypeIsNull_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.isInSequence(0, null));
  }

  @Test
  void isInSequence_whenTypeIsNotGiven_shouldUseDefaultType() {
    int number = 8;
    boolean expected = FibonacciSequence.isInSequence(number,
        FibonacciSequence.DEFAULT_TYPE);
    boolean actual = FibonacciSequence.isInSequence(number);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(CalculationType.class)
  void isInSequence_whenTypeIsGiven_shouldUseGivenType(CalculationType type) {
    int number = 13;
    boolean expected = type.getFibonacciGenerator()
        .isInSequence(number);
    boolean actual = FibonacciSequence.isInSequence(number, type);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(CalculationType.class)
  void isInSequence_whenTypeIsGiven_shouldReturnSameResultForAllTypes(
      CalculationType type) {
    int number = 13;
    boolean actual = FibonacciSequence.isInSequence(number, type);
    assertTrue(actual);
  }

  @Test
  void getIndex_whenNegativeNumber_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.getIndex(-1));
  }

  @Test
  void getIndex_whenTypeIsNull_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> FibonacciSequence.getIndex(0, null));
  }

  @Test
  void getIndex_whenTypeIsNotGiven_shouldUseDefaultType() {
    int number = 7;
    int expected = FibonacciSequence.getIndex(number,
        FibonacciSequence.DEFAULT_TYPE);
    int actual = FibonacciSequence.getIndex(number);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(CalculationType.class)
  void getIndex_whenTypeIsGiven_shouldUseGivenType(CalculationType type) {
    int number = 34;
    int expected = type.getFibonacciGenerator()
        .getIndex(number);
    int actual = FibonacciSequence.getIndex(number, type);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(CalculationType.class)
  void getIndex_whenTypeIsGiven_shouldReturnSameResultForAllTypes(
      CalculationType type) {
    int number = 34;
    int expected = 9;
    int actual = FibonacciSequence.getIndex(number, type);
    assertEquals(expected, actual);
  }

}
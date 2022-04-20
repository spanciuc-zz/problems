package com.pantifik.problems.array.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class ObjectArraySwapTest {

  @ParameterizedTest
  @NullSource
  void swap_whenGivenNull_shouldThrowException(Integer[] array) {
    assertThrows(NullPointerException.class, () -> ArraySwap.swap(array, 0, 0));
  }

  @ParameterizedTest
  @MethodSource("provideIllegalArguments")
  void swap_whenInvalidIndexesGiven_shouldThrowException(Integer[] array,
      int indexFrom, int indexTo) {
    assertThrows(IndexOutOfBoundsException.class,
        () -> ArraySwap.swap(array, indexFrom, indexTo));
  }

  @Test
  void swap_shouldInterchangeObjectsAtGivenIndexesInArray() {
    int indexFrom = 0;
    int indexTo = 2;
    Object[] expected = {3, 2, 1};
    Object[] actual = {1, 2, 3};
    ArraySwap.swap(actual, indexFrom, indexTo);
    assertArrayEquals(expected, actual);
  }

  private static Stream<Arguments> provideIllegalArguments() {
    return Stream.of(Arguments.of(new Integer[]{1, 2}, -1, 0),
        Arguments.of(new Integer[]{1, 2}, 0, -2),
        Arguments.of(new Integer[]{1, 2}, -3, -4),
        Arguments.of(new Integer[]{1, 2}, 0, 3),
        Arguments.of(new Integer[]{1, 2}, 2, 0),
        Arguments.of(new Integer[]{1, 2, 3, 4}, 5, 6));
  }

}
package com.pantifik.problems.array.reverse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ReverseArrayTest {

  @ParameterizedTest
  @NullAndEmptySource
  void reverse_whenNull_shouldThrowException(Object[] arr) {
    assertThrows(IllegalArgumentException.class,
        () -> ReverseArray.reverse(arr));
  }

  @ParameterizedTest
  @MethodSource("arraysProvider")
  <T> void reverse_shouldReverseArray(T[] actual, T[] expected) {
    ReverseArray.reverse(actual);
    assertArrayEquals(expected, actual);
  }

  private static Stream<Arguments> arraysProvider() {
    return Stream.of(Arguments.of(new Object[]{1, null, "2", 3.3, 4.0f},
            new Object[]{4.0f, 3.3, "2", null, 1}),
        Arguments.of(new Integer[]{1, 2, 3, 4, 5},
            new Integer[]{5, 4, 3, 2, 1}),
        Arguments.of(new Object[]{1L, null, 3.3f, 4.0},
            new Object[]{4.0, 3.3f, null, 1L}));
  }
}
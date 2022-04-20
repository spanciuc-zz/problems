package com.pantifik.problems.permutations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringPermutationsTest {

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {" "})
  void count_whenInvalidFromString_shouldThrowException(String from) {
    assertThrows(IllegalArgumentException.class,
        () -> StringPermutations.count(from, 0));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 4})
  void count_whenInvalidCount_shouldThrowException(int count) {
    assertThrows(IllegalArgumentException.class,
        () -> StringPermutations.count("abc", count));
  }

  @ParameterizedTest
  @CsvSource({"1, 1, 1", "12, 1, 2", "12345, 2, 20"})
  void count_whenValidParams_shouldReturnPermutationsCount(String from,
      int count, int expected) {
    assertEquals(expected, StringPermutations.count(from, count));
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {" "})
  void generate_whenInvalidFromString_shouldThrowException(String from) {
    assertThrows(IllegalArgumentException.class,
        () -> StringPermutations.generate(from, 0));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 4})
  void generate_whenInvalidCount_shouldThrowException(int count) {
    assertThrows(IllegalArgumentException.class,
        () -> StringPermutations.generate("abc", count));
  }

  @ParameterizedTest
  @MethodSource("permutationsProvider")
  void generate_whenValidParams_shouldReturnAllPermutations(String from,
      int count, List<String> expected) {
    assertEquals(expected, StringPermutations.generate(from, count));
  }

  private static Stream<Arguments> permutationsProvider() {
    return Stream.of(
        Arguments.of("1", 1, List.of("1")),
        Arguments.of("12", 1, List.of("1", "2")),
        Arguments.of("123", 2, List.of("12", "13", "21", "23", "31", "32")),
        Arguments.of("123", 3, List.of("123", "132", "213", "231", "312", "321"))
    );
  }

}
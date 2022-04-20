package com.pantifik.problems.combinations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CombinationsTest {

  @Test
  void count_whenNullRequest_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> Combinations.count(null));
  }

  @Test
  void count_whenUsingRequestAndNullType_shouldThrowException() {
    CombinationsRequest<Integer> request = CombinationsRequest.of(List.of(1),
        1);
    assertThrows(IllegalArgumentException.class,
        () -> Combinations.count(request, null));
  }

  @Test
  void count_whenNotUsingRequestAndNullType_shouldThrowException() {
    List<Integer> of = List.of(1);
    int by = 1;
    assertThrows(IllegalArgumentException.class,
        () -> Combinations.count(of, by, null));
  }

  @ParameterizedTest
  @NullAndEmptySource
  <T> void count_whenInvalidList_shouldThrowException(List<T> of) {
    assertThrows(IllegalArgumentException.class,
        () -> Combinations.count(of, 0));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 4})
  void count_whenInvalidNumber_shouldThrowException(int by) {
    List<Integer> of = List.of(1, 2, 3);
    assertThrows(IllegalArgumentException.class,
        () -> Combinations.count(of, by));
  }

  @Test
  void count_whenUsingRequestAndTypeIsNotGiven_shouldUseDefault() {
    int actual = Combinations.count(
        CombinationsRequest.of(List.of(1, 2, 3), 2));
    int expected = Combinations.DEFAULT_TYPE.getGenerator()
        .count(CombinationsRequest.of(List.of(1, 2, 3), 2));
    assertEquals(expected, actual);
  }

  @Test
  void count_whenNotUsingRequestAndTypeIsNotGiven_shouldUseDefault() {
    int actual = Combinations.count(List.of(1, 2, 3), 2);
    int expected = Combinations.DEFAULT_TYPE.getGenerator()
        .count(CombinationsRequest.of(List.of(1, 2, 3), 2));
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(Combinations.Type.class)
  void count_whenUsingRequestAndTypeIsGiven_shouldCalculateCountUsingGivenType(
      Combinations.Type type) {
    CombinationsRequest<String> request = CombinationsRequest.of(
        List.of("a", "b", "c", "d"), 2);
    int expected = type.getGenerator()
        .count(request);
    int actual = Combinations.count(request, type);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(Combinations.Type.class)
  void count_whenNotUsingRequestAndTypeIsGiven_shouldCalculateCountUsingGivenType(
      Combinations.Type type) {
    List<String> of = List.of("a", "b", "c", "d");
    int by = 3;
    int expected = type.getGenerator()
        .count(CombinationsRequest.of(of, by));
    int actual = Combinations.count(of, by, type);
    assertEquals(expected, actual);
  }

  @Test
  void generate_whenNullRequest_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> Combinations.generate(null));
  }

  @Test
  void generate_whenUsingRequestAndNullType_shouldThrowException() {
    CombinationsRequest<Integer> request = CombinationsRequest.of(List.of(1),
        1);
    assertThrows(IllegalArgumentException.class,
        () -> Combinations.generate(request, null));
  }

  @Test
  void generate_whenNotUsingRequestAndNullType_shouldThrowException() {
    List<Integer> of = List.of(1);
    int by = 1;
    assertThrows(IllegalArgumentException.class,
        () -> Combinations.generate(of, by, null));
  }

  @ParameterizedTest
  @NullAndEmptySource
  <T> void generate_whenInvalidList_shouldThrowException(List<T> of) {
    assertThrows(IllegalArgumentException.class,
        () -> Combinations.generate(of, 0));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 4})
  void generate_whenInvalidNumber_shouldThrowException(int by) {
    List<Integer> of = List.of(1, 2, 3);
    assertThrows(IllegalArgumentException.class,
        () -> Combinations.count(of, by));
  }

}
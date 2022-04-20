package com.pantifik.problems.combinations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CombinationsWithoutRepetitionsTest {

  CombinationsGenerator combinationsGenerator;

  @BeforeEach
  void setUp() {
    combinationsGenerator = new CombinationsWithoutRepetitions();
  }

  @ParameterizedTest
  @MethodSource("combinationsCountProvider")
  <T> void count_whenValidParams_shouldReturnNumberOfCombinations(
      CombinationsRequest<T> request, int expected) {
    assertEquals(expected, combinationsGenerator.count(request));
  }

  @ParameterizedTest
  @MethodSource("combinationsGenerateProvider")
  <T> void generate_whenValidParams_shouldReturnListOfAllCombinations(
      CombinationsRequest<T> request, List<List<T>> expected) {
    assertEquals(expected, combinationsGenerator.generate(request));
  }

  private static Stream<Arguments> combinationsCountProvider() {
    return Stream.of(Arguments.of(CombinationsRequest.of(List.of(1), 1), 1),
        Arguments.of(CombinationsRequest.of(List.of(1, 2), 1), 2),
        Arguments.of(CombinationsRequest.of(List.of(1, 2, 3), 2), 3),
        Arguments.of(CombinationsRequest.of(List.of(1, 2, 3, 4, 5), 3), 10));
  }

  private static Stream<Arguments> combinationsGenerateProvider() {
    return Stream.of(Arguments.of(CombinationsRequest.of(List.of(1), 1),
            List.of(List.of(1))),
        Arguments.of(CombinationsRequest.of(List.of(1, 2), 1),
            List.of(List.of(1), List.of(2))),
        Arguments.of(CombinationsRequest.of(List.of(1, 2), 2),
            List.of(List.of(1, 2))),
        Arguments.of(CombinationsRequest.of(List.of(1, 2, 3), 2),
            List.of(List.of(1, 2), List.of(1, 3), List.of(2, 3))),
        Arguments.of(CombinationsRequest.of(List.of(1, 2, 3, 4), 2),
            List.of(List.of(1, 2), List.of(1, 3), List.of(1, 4), List.of(2, 3),
                List.of(2, 4), List.of(3, 4))));
  }

}
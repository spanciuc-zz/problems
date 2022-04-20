package com.pantifik.problems.permutations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PermutationsWithoutRepetitionsTest {

  PermutationsWithoutRepetitions permutationsGenerator;

  @BeforeEach
  void setup() {
    permutationsGenerator = new PermutationsWithoutRepetitions();
  }

  @Test
  void calculateCount_whenValidParams_shouldReturnPermutationsCount() {
    List<Object> from = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    int count = 2;
    int expected = 90;
    assertEquals(expected, permutationsGenerator.count(from, count));
  }

  @ParameterizedTest
  @MethodSource("permutationsProvider")
  <T> void generate_test(List<T> from, int count, List<List<T>> expected) {

    List<List<T>> actual = permutationsGenerator.generate(from, count);

    assertEquals(expected, actual);
  }

  private static Stream<Arguments> permutationsProvider() {
    return Stream.of(Arguments.of(Arrays.asList(1, 2), 2,
            List.of(List.of(1, 2), List.of(2, 1))),
        Arguments.of(Arrays.asList(1, 2, 3), 2,
            List.of(List.of(1, 2), List.of(1, 3), List.of(2, 1), List.of(2, 3),
                List.of(3, 1), List.of(3, 2))),
        Arguments.of(Arrays.asList(1, 2, 3), 3,
            List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3),
                List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1))),
        Arguments.of(Arrays.asList(1, 2, 3, 4), 2,
            List.of(List.of(1, 2), List.of(1, 3), List.of(1, 4), List.of(2, 1),
                List.of(2, 3), List.of(2, 4), List.of(3, 1), List.of(3, 2),
                List.of(3, 4), List.of(4, 1), List.of(4, 2), List.of(4, 3))),
        Arguments.of(Arrays.asList(1, 2, 3, 4), 1,
            List.of(List.of(1), List.of(2), List.of(3), List.of(4))));
  }


}
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

class PermutationsWithRepetitionsTest {

  PermutationsWithRepetitions permutationsGenerator;

  @BeforeEach
  void setup() {
    permutationsGenerator = new PermutationsWithRepetitions();
  }

  @Test
  void calculateCount_whenValidParams_shouldReturnPermutationsCount() {
    List<Object> from = Arrays.asList(1, 2, 3);
    int count = 2;
    int expected = 9;
    assertEquals(expected, permutationsGenerator.count(from, count));
  }

  @ParameterizedTest
  @MethodSource("permutationsProvider")
  <T> void generate_test(List<T> from, int count, List<List<T>> expected) {

    List<List<T>> actual = permutationsGenerator.generate(from, count);

    assertEquals(expected, actual);
  }

  private static Stream<Arguments> permutationsProvider() {
    return Stream.of(Arguments.of(Arrays.asList(1, 2), 1,
            Arrays.asList(Arrays.asList(1), Arrays.asList(2))),
        Arguments.of(Arrays.asList(1, 2), 2,
            Arrays.asList(Arrays.asList(1, 1), Arrays.asList(1, 2),
                Arrays.asList(2, 1), Arrays.asList(2, 2))),
        Arguments.of(Arrays.asList(1, 2, 3), 2,
            Arrays.asList(Arrays.asList(1, 1), Arrays.asList(1, 2),
                Arrays.asList(1, 3), Arrays.asList(2, 1), Arrays.asList(2, 2),
                Arrays.asList(2, 3), Arrays.asList(3, 1), Arrays.asList(3, 2),
                Arrays.asList(3, 3))));
  }

}
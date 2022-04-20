package com.pantifik.problems.permutations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Test;

class PermutationsTest {

  @Test
  void calculateCount_whenNoPermutationTypeGiven_shouldUseDefault() {

    List<Object> from = List.of(1, 2, 3);

    int count = 2;

    int expected = Permutations.calculateCount(from, count,
        Permutations.defaultType);

    assertEquals(expected, Permutations.calculateCount(from, count));

  }

  @Test
  void calculateCount_whenNullPermutationGiven_shouldThrowException() {
    List<Object> from = List.of(1);
    assertThrows(IllegalArgumentException.class,
        () -> Permutations.calculateCount(from, 1, null));

  }

  @Test
  void generate_whenNoPermutationTypeGiven_shouldUseDefault() {

    List<Object> from = List.of(1, 2);

    int count = 1;

    List<List<Object>> expected = Permutations.generate(from, count,
        Permutations.defaultType);

    assertEquals(expected, Permutations.generate(from, count));

  }

  @Test
  void generate_whenNullPermutationGiven_shouldThrowException() {
    List<Object> from = List.of(1);
    assertThrows(IllegalArgumentException.class,
        () -> Permutations.generate(from, 1, null));

  }

}
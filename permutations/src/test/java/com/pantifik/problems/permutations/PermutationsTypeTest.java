package com.pantifik.problems.permutations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class PermutationsTypeTest {

  @ParameterizedTest
  @EnumSource(Permutations.Type.class)
  void getPermutationsGenerator_shouldNotThrowException(
      Permutations.Type type) {
    assertDoesNotThrow(() -> type.getPermutationsGenerator());
  }

  @ParameterizedTest
  @EnumSource(Permutations.Type.class)
  void getPermutationsGenerator_shouldReturnNotNullResult(
      Permutations.Type type) {
    assertNotNull(type.getPermutationsGenerator());
  }
}
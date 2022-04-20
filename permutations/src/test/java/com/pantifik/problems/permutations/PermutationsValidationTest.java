package com.pantifik.problems.permutations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PermutationsValidationTest {

  @ParameterizedTest
  @NullAndEmptySource
  <T> void validateFromList_whenNullOrEmptyArray_shouldThrowException(
      List<T> from) {
    assertThrows(IllegalArgumentException.class,
        () -> PermutationsValidation.validateFromList(from));
  }

  @Test
  void validateFromList_whenHasDuplications_shouldThrowException() {
    List<Object> from = Arrays.asList(1, 2, 1);
    assertThrows(IllegalArgumentException.class,
        () -> PermutationsValidation.validateFromList(from));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 3})
  void validateCount_whenLessThanOneOrGreaterThanArraySize_shouldThrowException(
      int count) {
    List<Object> from = Arrays.asList("a", "b");
    assertThrows(IllegalArgumentException.class,
        () -> PermutationsValidation.validateCount(from,
            count));
  }

}
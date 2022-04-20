package com.pantifik.problems.combinations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CombinationsUtilsTest {

  @Test
  void createAndFillWithNull_whenNegativeCount_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> CombinationsUtils.createAndFillWithNull(-1));
  }

  @Test
  void createAndFillWithNull_shouldReturnAListOfGivenSizeWithNullElements() {
    List<Integer> expected = Arrays.asList(null, null, null);
    List<Integer> actual = CombinationsUtils.createAndFillWithNull(3);
    assertEquals(expected, actual);
  }

}
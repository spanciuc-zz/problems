package com.pantifik.problems.strings.unique;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TestUniqueCharsUsingBitwiseTest extends TestUniqueCharsTest {

  @Override
  protected TestUniqueCharsUsingBitwise getImplementation() {
    return new TestUniqueCharsUsingBitwise();
  }

  @ParameterizedTest
  @CsvSource({"0,48", "1,49", "9,57", "10, 65", "11, 66", "35, 97", "36, 98", "60, 122"})
  void normalizeIndex_whenInRange_shouldReturnExpectedIndex(int expected, int value) {
    TestUniqueCharsUsingBitwise testBitwise = (TestUniqueCharsUsingBitwise) test;
    assertEquals(expected, testBitwise.normalizeIndex(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 47, 58, 64, 91, 96, 123, 150})
  void normalizeIndex_whenNotInRange_shouldThrowException(int value) {
    TestUniqueCharsUsingBitwise testBitwise = (TestUniqueCharsUsingBitwise) test;
    assertThrows(IllegalArgumentException.class, () -> testBitwise.normalizeIndex(value));
  }

}
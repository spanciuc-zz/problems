package com.pantifik.problems.strings.unique;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

abstract class TestUniqueCharsTest {

  protected TestUniqueChars test;

  protected abstract TestUniqueChars getImplementation();

  @BeforeEach
  void setUp() {
    this.test = getImplementation();
  }

  @Test
  void check_whenNull_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> test.check(null));
  }

  @ParameterizedTest
  @ValueSource(strings = {"11", "aba", "qwertyuioACBNA"})
  void test_whenContainsRepeatedChars_shouldReturnFalse(String string) {
    assertFalse(test.check(string));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "1234567890", "qwertyuio"})
  void test_whenUniqueChars_shouldReturnTrue(String string) {
    assertTrue(test.check(string));
  }
}
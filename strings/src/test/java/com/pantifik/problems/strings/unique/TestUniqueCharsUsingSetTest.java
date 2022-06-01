package com.pantifik.problems.strings.unique;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TestUniqueCharsUsingSetTest extends TestUniqueCharsTest {

  @Override
  protected TestUniqueChars getImplementation() {
    return new TestUniqueCharsUsingSet();
  }

  @ParameterizedTest
  @ValueSource(strings = {"  ", "/[]l;/"})
  void test_whenContainsRepeatedSpecialChars_shouldReturnFalse(String string) {
    assertFalse(test.check(string));
  }

  @ParameterizedTest
  @ValueSource(strings = {" ", "/[]l;&*^%"})
  void test_whenNotContainsRepeatedSpecialChars_shouldReturnTrue(String string) {
    assertTrue(test.check(string));
  }
}
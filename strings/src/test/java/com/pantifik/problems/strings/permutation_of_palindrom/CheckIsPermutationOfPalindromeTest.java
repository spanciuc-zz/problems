package com.pantifik.problems.strings.permutation_of_palindrom;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

abstract class CheckIsPermutationOfPalindromeTest {

  protected CheckIsPermutationOfPalindrome checker;

  protected abstract CheckIsPermutationOfPalindrome createCheckerInstance();

  @BeforeEach
  void setUp() {
    this.checker = createCheckerInstance();
  }

  @ParameterizedTest
  @NullAndEmptySource
  void check_whenNull_shouldThrowException(String string) {
    assertThrows(IllegalArgumentException.class, () -> checker.check(string));
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "11", "111", "1112222", "121", "112", "211", "abcabcd", "ab7cdabcd"})
  void check_whenIsPermutationOfPalindrome_shouldReturnTrue(String string) {
    assertTrue(checker.check(string));
  }

  @ParameterizedTest
  @ValueSource(strings = {"12", "123", "1234", "11223356", "2511", "abcafbcd", "ab7cdab8cd"})
  void check_whenIsNotPermutationOfPalindrome_shouldReturnFalse(String string) {
    assertFalse(checker.check(string));
  }
}
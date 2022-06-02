package com.pantifik.problems.strings.permutations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

abstract class CheckArePermutationsTest {

  protected CheckArePermutations checker;

  public static Stream<Arguments> checkWhenNullProvider() {
    return Stream.of(Arguments.of(null, "second"), Arguments.of("first", null),
        Arguments.of(null, null));
  }

  public static Stream<Arguments> checkWhenDifferentSizeProvider() {
    return Stream.of(Arguments.of("", "1"), Arguments.of("123", "12"),
        Arguments.of("12345", "123456"));
  }

  public static Stream<Arguments> checkWhenArePermutationsProvider() {
    return Stream.of(Arguments.of("1", "1"), Arguments.of("12", "21"), Arguments.of("123", "321"),
        Arguments.of("123", "132"), Arguments.of("abbcdd", "babdcd"));
  }

  protected abstract CheckArePermutations getImplementation();

  @BeforeEach
  void setUp() {
    this.checker = getImplementation();
  }

  @ParameterizedTest
  @MethodSource("checkWhenNullProvider")
  void check_whenFirstIsNull_shouldThrowException(String first, String second) {
    assertThrows(NullPointerException.class, () -> checker.check(first, second));
  }

  @ParameterizedTest
  @MethodSource("checkWhenDifferentSizeProvider")
  void check_whenDifferentSizes_shouldReturnFalse(String first, String second) {
    assertFalse(checker.check(first, second));
  }

  @ParameterizedTest
  @MethodSource("checkWhenArePermutationsProvider")
  void check_whenArePermutations_shouldReturnTrue(String first, String second) {
    assertTrue(checker.check(first, second));
  }
}
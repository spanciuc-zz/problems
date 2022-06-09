package com.pantifik.problems.strings.edits_count;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IsOneOrNoEditsAwayCheckTest {

  public static Stream<Arguments> whenNullProvider() {
    return Stream.of(Arguments.of("asd", null), Arguments.of(null, "asd"),
        Arguments.of(null, null));
  }

  public static Stream<Arguments> whenIsOneOrNoEditsAwayProvider() {
    return Stream.of(Arguments.of("", ""), Arguments.of("1", ""), Arguments.of("", "1"),
        Arguments.of("asd", "asd"), Arguments.of("asd", "bsd"), Arguments.of("asd", "abd"),
        Arguments.of("asd", "asg"), Arguments.of("asd", "as"), Arguments.of("asd", "1asd"));
  }

  public static Stream<Arguments> whenIsNotOneOrNoEditsAwayProvider() {
    return Stream.of(Arguments.of("", "12"), Arguments.of("asd", "ag"),
        Arguments.of("12395678905", "1234567890"));
  }

  @ParameterizedTest
  @MethodSource("whenNullProvider")
  void check_whenNullParams_shouldThrowException(String first, String second) {
    assertThrows(NullPointerException.class, () -> IsOneOrNoEditsAwayCheck.check(first, second));
  }

  @ParameterizedTest
  @MethodSource("whenIsOneOrNoEditsAwayProvider")
  void check_whenIsOneOrNoEditsAway_shouldReturnTrue(String first, String second) {
    assertTrue(IsOneOrNoEditsAwayCheck.check(first, second));
  }

  @ParameterizedTest
  @MethodSource("whenIsNotOneOrNoEditsAwayProvider")
  void check_whenIsNotOneOrNoEditsAway_shouldReturnFalse(String first, String second) {
    assertFalse(IsOneOrNoEditsAwayCheck.check(first, second));
  }
}
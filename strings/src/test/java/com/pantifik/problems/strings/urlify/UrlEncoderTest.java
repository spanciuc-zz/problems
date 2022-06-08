package com.pantifik.problems.strings.urlify;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UrlEncoderTest {

  public static Stream<Arguments> encodeProvider() {
    return Stream.of(Arguments.of("", ""), Arguments.of("1", "1"), Arguments.of(" 1 ", "%201%20"),
        Arguments.of("  1  ", "%20%201%20%20"), Arguments.of("  1  23 3", "%20%201%20%2023%203"));
  }

  @Test
  void encode_whenNull_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> UrlEncoder.encode(null));
  }

  @ParameterizedTest
  @MethodSource("encodeProvider")
  void test(String text, String expected) {
    assertEquals(expected, UrlEncoder.encode(text));
  }
}
package com.pantifik.problems.strings.compression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public abstract class StringCompressionTest {

  protected StringCompression stringCompression;

  protected abstract StringCompression createInstance();

  @BeforeEach
  void setUp() {
    this.stringCompression = createInstance();
  }

  @Test
  void compress_whenNull_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> stringCompression.compress(null));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "#$&", "asds1AADD", "asklȚ"})
  void compress_whenContainsInvalidChars_shouldThrowException(String text) {
    assertThrows(IllegalArgumentException.class, () -> stringCompression.compress(text));
  }

  @ParameterizedTest
  @CsvSource(
      {"a3,aaa", "a2b3a3c4,aabbbaaacccc", "A3e3g3Z5,AAAeeegggZZZZZ", "a,a", "abcdefgA,abcdefgA"})
  void compress_whenValidText_shouldReturnCompressedText(String expected, String text) {
    assertEquals(expected, stringCompression.compress(text));
  }
}
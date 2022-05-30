package com.pantifik.problems.brackets.matcher;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BracketsMatcherTest {

  private BracketsMatcher matcher;

  private PairDictionary dictionary;

  @BeforeEach
  void setUp() {
    matcher = new BracketsMatcher();
    dictionary = new PairDictionary(
        List.of(new Pair('{', '}'), new Pair('(', ')'), new Pair('[', ']')));
  }

  @Test
  void check_whenNullDictionary_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> matcher.check("asd", null));
  }

  @Test
  void check_whenEmptyDictionary_shouldThrowException() {
    dictionary = new PairDictionary();
    assertThrows(IllegalArgumentException.class, () -> matcher.check("asd", dictionary));
  }

  @Test
  void check_whenNullSequence_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> matcher.check(null, dictionary));
  }

  @Test
  void check_whenBlankSequence_shouldThrowException() {
    assertThrows(IllegalArgumentException.class, () -> matcher.check("    ", dictionary));
  }

  @ParameterizedTest
  @ValueSource(strings = {"{[(){}[]]}", "(())", "{{{[]}()}{}}"})
  void check_whenMatch_shouldReturnTrue(String sequence) {
    assertTrue(matcher.check(sequence, dictionary));
  }

  @ParameterizedTest
  @ValueSource(strings = {"{[){}[]]}", "(({))", "{{{[]}(()}{}}", "[", "}", "()(())[34]{}", "}}"})
  void check_whenNotMatch_shouldReturnTrue(String sequence) {
    assertFalse(matcher.check(sequence, dictionary));
  }

}
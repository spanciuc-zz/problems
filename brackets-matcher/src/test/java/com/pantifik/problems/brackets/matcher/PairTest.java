package com.pantifik.problems.brackets.matcher;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class PairTest {

  @Test
  void constructor_whenSameLeftAndRight_shouldThrowException() {
    assertThrows(IllegalArgumentException.class, () -> new Pair('1', '1'));
  }

  @Test
  void constructor_whenNullLeft_shouldThrowException() {
    Character c = null;
    assertThrows(NullPointerException.class, () -> new Pair(c, '1'));
  }

  @Test
  void constructor_whenNullRight_shouldThrowException() {
    Character c = null;
    assertThrows(NullPointerException.class, () -> new Pair('1', c));
  }
}
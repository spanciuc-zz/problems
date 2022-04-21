package com.pantifik.problems.powersof;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Test;

class PowersOfTest {

  @Test
  void get_whenNumberIsLessThan1_shouldThrowException() {
    assertThrows(IllegalArgumentException.class, () -> PowersOf.get(0, 1));
  }

  @Test
  void get_whenPowerIsLessThan0_shouldThrowException() {
    assertThrows(IllegalArgumentException.class, () -> PowersOf.get(1, -1));
  }

  @Test
  void get_whenStrategyIsNull_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> PowersOf.get(15, 2, null));
  }

  @Test
  void get_whenStrategyNotGiven_shouldUseDefault() {
    int number = 10;
    int power = 3;
    List<Integer> expected = PowersOf.DEFAULT_STRATEGY.get(number, power);
    List<Integer> actual = PowersOf.get(number, power);
    assertEquals(expected, actual);
  }

  @Test
  void get_whenStrategyGiven_shouldUseGivenStrategy() {
    PowersOf.Strategy strategy = PowersOf.Strategy.ITERATIVE;
    int number = 10;
    int power = 5;
    List<Integer> expected = strategy.get(number, power);
    List<Integer> actual = PowersOf.get(number, power, strategy);
    assertEquals(expected, actual);
  }

}
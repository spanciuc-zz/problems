package com.pantifik.problems.factorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FactorialTest {

  @Test
  void calculate_whenStrategyNotGiven_shouldUseDefaultStrategy() {
    Factorial.Strategy strategy = Mockito.mock(Factorial.Strategy.class);
    Factorial.defaultStrategy = strategy;
    int number = 3;
    Factorial.calculate(number);
    Mockito.verify(strategy, Mockito.times(1))
        .calculate(number);
  }

  @Test
  void calculate_whenStrategyGiven_shouldUseGivenStrategy() {
    Factorial.Strategy strategy = Mockito.mock(Factorial.Strategy.class);
    int number = 3;
    Factorial.calculate(number, strategy);
    Mockito.verify(strategy, Mockito.times(1))
        .calculate(number);
  }

  @Test
  void isFactorial_whenStrategyNotGiven_shouldUseDefaultStrategy() {
    Factorial.Strategy strategy = Mockito.mock(Factorial.Strategy.class);
    Factorial.defaultStrategy = strategy;
    BigInteger number = BigInteger.TEN;
    Factorial.isFactorial(number);
    Mockito.verify(strategy, Mockito.times(1))
        .isFactorial(number);
  }

  @Test
  void isFactorial_whenStrategyGiven_shouldUseGivenStrategy() {
    Factorial.Strategy strategy = Mockito.mock(Factorial.Strategy.class);
    BigInteger number = BigInteger.TEN;
    Factorial.isFactorial(number, strategy);
    Mockito.verify(strategy, Mockito.times(1))
        .isFactorial(number);
  }

  @Test
  void calculate_whenStrategyNotGiven_shouldReturnDefaultStrategyResult() {
    Factorial.Strategy strategy = Mockito.mock(Factorial.Strategy.class);
    Factorial.defaultStrategy = strategy;
    int number = 3;
    BigInteger expected = BigInteger.ONE;
    Mockito.when(strategy.calculate(number))
        .thenReturn(expected);
    assertEquals(expected, Factorial.calculate(number));
  }

  @Test
  void calculate_whenStrategyGiven_shouldReturnGivenStrategyResult() {
    Factorial.Strategy strategy = Mockito.mock(Factorial.Strategy.class);
    int number = 3;
    BigInteger expected = BigInteger.ONE;
    Mockito.when(strategy.calculate(number))
        .thenReturn(expected);
    assertEquals(expected, Factorial.calculate(number, strategy));
  }

  @Test
  void isFactorial_whenStrategyNotGiven_shouldReturnDefaultStrategyResult() {
    Factorial.Strategy strategy = Mockito.mock(Factorial.Strategy.class);
    Factorial.defaultStrategy = strategy;
    BigInteger number = BigInteger.TEN;
    boolean expected = true;
    Mockito.when(strategy.isFactorial(number))
        .thenReturn(expected);
    assertEquals(expected, Factorial.isFactorial(number));
  }

  @Test
  void isFactorial_whenStrategyGiven_shouldReturnGivenStrategyResult() {
    Factorial.Strategy strategy = Mockito.mock(Factorial.Strategy.class);
    Factorial.defaultStrategy = strategy;
    BigInteger number = BigInteger.TEN;
    boolean expected = false;
    Mockito.when(strategy.isFactorial(number))
        .thenReturn(expected);
    assertEquals(expected, Factorial.isFactorial(number, strategy));
  }

}
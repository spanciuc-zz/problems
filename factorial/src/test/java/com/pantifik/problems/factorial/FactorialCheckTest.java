package com.pantifik.problems.factorial;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigInteger;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

abstract class FactorialCheckTest {

  protected Predicate<BigInteger> factorialCheck;

  @Test
  void test_whenNull_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> factorialCheck.test(null));
  }

  @ParameterizedTest
  @CsvSource({"-5", "-1", "0"})
  void test_whenNegativeOrZero_shouldThrowException(BigInteger value) {
    assertThrows(IllegalArgumentException.class,
        () -> factorialCheck.test(value));
  }

  @ParameterizedTest
  @CsvSource(
      {"1", "2", "6", "24", "3628800", "265252859812191058636308480000000"})
  void test_whenIsFactorial_shouldReturnTrue(BigInteger number) {
    assertTrue(factorialCheck.test(number));
  }

  @ParameterizedTest
  @CsvSource(
      {"3", "5", "11", "110", "3628801", "265252859812191058636308480000001"})
  void test_whenIsNotFactorial_shouldReturnFalse(BigInteger number) {
    assertFalse(factorialCheck.test(number));
  }
}

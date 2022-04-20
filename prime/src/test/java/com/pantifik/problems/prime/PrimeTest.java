package com.pantifik.problems.prime;

import static com.pantifik.problems.prime.Prime.isPrime;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PrimeTest {

  @Test
  void isPrime_whenNegative_shouldThrowException() {
    assertThrows(IllegalArgumentException.class, () -> isPrime(-1));
  }

  @Test
  void isPrime_whenNonNegativeLessThan1_shouldReturnFalse() {
    assertFalse(isPrime(0));
    assertFalse(isPrime(1));
  }

  @Test
  void isPrime_whenNotPrime_shouldReturnFalse() {
    assertFalse(isPrime(4));
  }

  @Test
  void isPrime_whenPrime_shouldReturnTrue() {
    assertTrue(isPrime(2));
  }
}
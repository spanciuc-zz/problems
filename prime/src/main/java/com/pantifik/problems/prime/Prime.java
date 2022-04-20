package com.pantifik.problems.prime;

/**
 * Provides useful operations with prime numbers.
 */
public final class Prime {

  private Prime() {
  }

  /**
   * Checks whether the given number is prime.
   *
   * <p>Complexity O(sqrt(n))</p>
   *
   * @param number
   *     the number to check, non-negative integer.
   * @return true if prime, false otherwise.
   *
   * @throws IllegalArgumentException
   *     if the number is negative.
   */
  public static boolean isPrime(final int number) {
    if (number < 0) {
      throw new IllegalArgumentException("Number must be non-negative integer");
    }
    if (number == 0 || number == 1) {
      return false;
    }
    // i * i to avoid Math.sqrt(number)
    for (int i = 2; i * i <= number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

}

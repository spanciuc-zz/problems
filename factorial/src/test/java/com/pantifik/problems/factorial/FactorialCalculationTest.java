package com.pantifik.problems.factorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigInteger;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

abstract class FactorialCalculationTest {

  protected UnaryOperator<BigInteger> calculator;

  @Test
  void calculate_whenNull_shouldThrowException() {
    assertThrows(IllegalArgumentException.class, () -> calculator.apply(null));
  }

  @Test
  void calculate_whenNegative_shouldThrowException() {
    BigInteger negative = BigInteger.valueOf(-1);
    assertThrows(IllegalArgumentException.class,
        () -> calculator.apply(negative));
  }

  @Test
  void calculate_when0_shouldReturn1() {
    BigInteger expected = BigInteger.ONE;
    BigInteger actual = calculator.apply(BigInteger.ZERO);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({"1,1", "2,2", "3,6", "4,24", "20,2432902008176640000",
      "30,265252859812191058636308480000000"})
  void calculate_shouldReturnFactorialValue(BigInteger number,
      BigInteger expected) {
    BigInteger actual = calculator.apply(number);
    assertEquals(expected, actual);
  }

}

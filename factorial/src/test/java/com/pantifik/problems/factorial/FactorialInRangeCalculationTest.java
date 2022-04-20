package com.pantifik.problems.factorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigInteger;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

abstract class FactorialInRangeCalculationTest {

  protected BinaryOperator<BigInteger> calculator;

  @Test
  void calculateInRange_whenFromParamIsNull_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> calculator.apply(null, BigInteger.ZERO));
  }

  @Test
  void calculateInRange_whenToParamIsNull_shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> calculator.apply(BigInteger.ZERO, null));
  }

  @Test
  void calculateInRange_whenFromParamIsNegative_shouldThrowException() {
    BigInteger negative = BigInteger.valueOf(-1);
    assertThrows(IllegalArgumentException.class,
        () -> calculator.apply(negative, BigInteger.ZERO));
  }

  @Test
  void calculateInRange_whenToParamIsNegative_shouldThrowException() {
    BigInteger negative = BigInteger.valueOf(-1);
    assertThrows(IllegalArgumentException.class,
        () -> calculator.apply(BigInteger.ZERO, negative));
  }

  @Test
  void calculateInRange_whenToParamIsNotGreaterThanFromParam_shouldThrowException() {
    BigInteger from = BigInteger.valueOf(10);
    BigInteger to = BigInteger.valueOf(5);
    assertThrows(IllegalArgumentException.class,
        () -> calculator.apply(from, to));
  }

  @ParameterizedTest
  @CsvSource({"2, 2, 2", "1,2,2", "1,3,6", "3, 6, 360", "10, 20, 6704425728000"})
  void calculate_shouldReturnFactorialValue(BigInteger from,BigInteger to,
      BigInteger expected) {
    BigInteger actual = calculator.apply(from, to);
    assertEquals(expected, actual);
  }

}

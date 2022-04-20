package com.pantifik.problems.factorial;

import org.junit.jupiter.api.BeforeEach;

class RecursiveFactorialInRangeTest extends FactorialInRangeCalculationTest {

  @BeforeEach
  void setUp() {
    this.calculator = RecursiveFactorial::calculateInRange;
  }

}
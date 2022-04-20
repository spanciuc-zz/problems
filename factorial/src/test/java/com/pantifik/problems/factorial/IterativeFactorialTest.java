package com.pantifik.problems.factorial;

import org.junit.jupiter.api.BeforeEach;

class IterativeFactorialTest extends FactorialCalculationTest {

  @BeforeEach
  void setUp() {
    this.calculator = IterativeFactorial::calculate;
  }

}
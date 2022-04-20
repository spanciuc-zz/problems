package com.pantifik.problems.factorial;

import org.junit.jupiter.api.BeforeEach;

class RecursiveFactorialTest extends FactorialCalculationTest {

  @BeforeEach
  void setUp() {
    this.calculator = RecursiveFactorial::calculate;
  }

}
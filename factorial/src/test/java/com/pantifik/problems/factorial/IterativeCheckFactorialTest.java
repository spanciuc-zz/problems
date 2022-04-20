package com.pantifik.problems.factorial;

import org.junit.jupiter.api.BeforeEach;

class IterativeCheckFactorialTest extends FactorialCheckTest {

  @BeforeEach
  void setUp() {
    this.factorialCheck = IterativeFactorialCheck::test;
  }
}
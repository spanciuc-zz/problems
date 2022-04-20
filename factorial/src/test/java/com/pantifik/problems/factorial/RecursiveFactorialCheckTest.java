package com.pantifik.problems.factorial;

import org.junit.jupiter.api.BeforeEach;

class RecursiveFactorialCheckTest extends FactorialCheckTest {

  @BeforeEach
  void setUp() {
    this.factorialCheck = RecursiveFactorialCheck::test;
  }
}
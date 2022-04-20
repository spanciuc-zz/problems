package com.pantifik.problems.fibonacci;

import org.junit.jupiter.api.BeforeEach;

class IterativeFibonacciTest extends FibonacciTest {

  @BeforeEach
  @Override
  protected void setUp() {
    this.fibonacci = new IterativeFibonacci();
  }

}
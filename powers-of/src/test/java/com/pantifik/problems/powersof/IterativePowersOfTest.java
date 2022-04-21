package com.pantifik.problems.powersof;

import org.junit.jupiter.api.BeforeEach;

class IterativePowersOfTest extends StrategyPowersOfTest {


  @BeforeEach
  @Override
  protected void setUp() {
    this.powersOfCalculator = IterativePowersOf::get;
  }
}
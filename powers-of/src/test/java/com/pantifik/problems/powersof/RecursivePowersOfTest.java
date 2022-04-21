package com.pantifik.problems.powersof;

import org.junit.jupiter.api.BeforeEach;

public class RecursivePowersOfTest extends StrategyPowersOfTest {

  @BeforeEach
  @Override
  protected void setUp() {
    this.powersOfCalculator = RecursivePowersOf::get;
  }

}

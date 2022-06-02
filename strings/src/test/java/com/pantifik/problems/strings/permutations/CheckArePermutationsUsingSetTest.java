package com.pantifik.problems.strings.permutations;

class CheckArePermutationsUsingSetTest extends CheckArePermutationsTest {


  @Override
  protected CheckArePermutations getImplementation() {
    return new CheckArePermutationsUsingMap();
  }


}
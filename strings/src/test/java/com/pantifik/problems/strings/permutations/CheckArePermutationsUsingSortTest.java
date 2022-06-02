package com.pantifik.problems.strings.permutations;

class CheckArePermutationsUsingSortTest extends CheckArePermutationsTest {
  @Override
  protected CheckArePermutations getImplementation() {
    return new CheckArePermutationsUsingSort();
  }
}
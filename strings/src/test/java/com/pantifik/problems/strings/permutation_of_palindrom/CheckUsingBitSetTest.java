package com.pantifik.problems.strings.permutation_of_palindrom;

class CheckUsingBitSetTest extends CheckIsPermutationOfPalindromeTest {

  @Override
  protected CheckIsPermutationOfPalindrome createCheckerInstance() {
    return new CheckUsingBitSet();
  }
}
package com.pantifik.problems.strings.permutation_of_palindrom;

class CheckUsingHashSetTest extends CheckIsPermutationOfPalindromeTest {

  @Override
  protected CheckIsPermutationOfPalindrome createCheckerInstance() {
    return new CheckUsingHashSet();
  }
}
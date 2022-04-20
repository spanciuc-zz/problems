package com.pantifik.problems.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for working with permutations with repetitions.
 */
class PermutationsWithRepetitions implements PermutationsGenerator {

  /**
   * Calculates number of permutations.
   *
   * <p>The count of permutations with repetitions is calculated by the
   * formula: (n^r), * where n - number of elements to choose from and r -
   * number of elements to * choose.
   *
   * @param from  list of elements to choose from.
   * @param count number of elements to choose.
   * @return the number of possible permutations.
   */
  public int count(final List<?> from, int count) {

    PermutationsValidation.validateFromList(from);

    PermutationsValidation.validateCount(from, count);

    return (int) Math.pow(from.size(), count);

  }

  /**
   * Generates the possible permutations with repetitions.
   *
   * <p>Complexity n*n^r, where n - elements to choose from and r - number of
   * elements to choose.
   *
   * @param from  list of elements, must not be null or empty.
   * @param count number of element to choose, must be in range [1, number of
   *              elements].
   * @param <T>   type of the elements.
   * @return a list of all possible permutation.
   * @throws IllegalArgumentException in case of invalid arguments are given.
   */
  public <T> List<List<T>> generate(final List<T> from, final int count) {
    PermutationsValidation.validateFromList(from);
    PermutationsValidation.validateCount(from, count);

    List<List<T>> permutations = new ArrayList<>();

    List<T> permutation = PermutationsUtils.createPermutationAndFillWithNull(
        count);

    generatePermutations(from, count, 0, permutation, permutations);

    return permutations;
  }

  private static <T> void generatePermutations(final List<T> from, int count,
      int currentIndex, final List<T> currentPermutation,
      final List<List<T>> permutations) {
    if (currentIndex == count) {
      permutations.add(new ArrayList<>(currentPermutation));
      return;
    }

    for (T elem : from) {
      currentPermutation.set(currentIndex, elem);
      generatePermutations(from, count, currentIndex + 1, currentPermutation,
          permutations);
    }

  }

}

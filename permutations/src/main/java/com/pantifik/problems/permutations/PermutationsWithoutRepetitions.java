package com.pantifik.problems.permutations;

import com.pantifik.problems.factorial.Factorial;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for working with permutations without repetitions.
 */
class PermutationsWithoutRepetitions implements PermutationsGenerator {

  /**
   * Calculates number of possible permutations.
   * <p>
   * The count of permutations without repetitions is calculated by the formula:
   * (n!) / (n - r)!, * where n - number of elements to choose from and r -
   * number of elements to * choose.
   *
   * @param from
   *     elements to choose from.
   * @param count
   *     number of element to choose.
   */
  public int count(List<?> from, int count) {

    PermutationsValidation.validateFromList(from);

    PermutationsValidation.validateCount(from, count);

    int upperBound = from.size();
    int lowerBound = upperBound - count + 1;

    return Factorial.calculate(lowerBound, upperBound)
        .intValue();

  }

  /**
   * Generates the list of possible permutations.
   * <p>
   * Complexity r*n*n!, where n - elements to choose from and r - number of
   * elements to choose.
   *
   * @param from
   *     elements to choose from.
   * @param count
   *     number of elements to choose.
   * @param <T>
   *     type of the elements.
   * @return List of all possible permutations.
   */
  @Override
  public <T> List<List<T>> generate(final List<T> from, final int count) {

    PermutationsValidation.validateFromList(from);

    PermutationsValidation.validateCount(from, count);

    List<List<T>> permutations = new ArrayList<>();

    List<T> permutation = PermutationsUtils.createPermutationAndFillWithNull(
        count);

    generatePermutations(from, count, 0, permutation, permutations);

    return permutations;
  }

  private <T> void generatePermutations(List<T> from, int count,
      int currentIndex, List<T> currentPermutation,
      List<List<T>> permutations) {

    if (currentIndex == count) {
      permutations.add(new ArrayList<>(currentPermutation));
      return;
    }

    for (T elem : from) {
      currentPermutation.set(currentIndex, elem);
      List<T> remainingFrom = from.stream()
          .filter(e -> !e.equals(elem))
          .toList();
      generatePermutations(remainingFrom, count, currentIndex + 1,
          currentPermutation, permutations);
    }

  }
}

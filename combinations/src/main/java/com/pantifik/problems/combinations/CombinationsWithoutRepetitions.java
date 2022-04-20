package com.pantifik.problems.combinations;

import com.pantifik.problems.factorial.Factorial;
import java.util.ArrayList;
import java.util.List;

class CombinationsWithoutRepetitions implements CombinationsGenerator {
  /**
   * Calculates the number of possible combinations.
   *
   * The number is calculated by formula n! / r! * (n - r)!, where n - number of
   * elements to choose from and r - number of elements to choose.
   *
   * @param request
   *     the combinations request, see {@link CombinationsRequest}.
   * @param <T>
   *     the type of the elements in request.
   * @return the number of all possible combinations.
   */
  @Override
  public <T> int count(CombinationsRequest<T> request) {
    if (request == null) {
      throw new IllegalArgumentException("Request must not be null");
    }
    int upperBound = request.getOf()
        .size();
    int lowerBound = upperBound - request.getBy() + 1;

    return Factorial.calculate(lowerBound, upperBound)
        .intValue() / Factorial.calculate(request.getBy())
        .intValue();
  }

  /**
   * Generates a list of all possible combinations.
   *
   * The complexity: r * n!, where n - number of * elements to choose from and r
   * - number of elements to choose.
   *
   * @param request
   *     the combination request, see {@link CombinationsRequest}.
   * @param <T>
   *     type of the elements in request.
   * @return the list of all possible combinations.
   */
  @Override
  public <T> List<List<T>> generate(CombinationsRequest<T> request) {
    if (request == null) {
      throw new IllegalArgumentException("Request must not be null");
    }

    List<T> combination = CombinationsUtils.createAndFillWithNull(
        request.getBy());

    List<List<T>> combinations = new ArrayList<>();

    generateHelper(request.getOf(), request.getBy(), 0, combination,
        combinations);

    return combinations;
  }

  private static <T> void generateHelper(List<T> of, int by, int currentIndex,
      List<T> combination, List<List<T>> combinations) {

    if (currentIndex == by) {
      combinations.add(new ArrayList<>(combination));
      return;
    }

    for (int x = 0; x < of.size(); x++) {
      T elem = of.get(x);
      combination.set(currentIndex, elem);
      List<T> remainingOf = of.subList(x + 1, of.size());
      generateHelper(remainingOf, by, currentIndex + 1, combination,
          combinations);
    }

  }

}

package com.pantifik.problems.combinations;

import com.pantifik.problems.factorial.Factorial;
import java.util.ArrayList;
import java.util.List;

class CombinationsWithRepetitions implements CombinationsGenerator {

  /**
   * Calculates the number of possible combinations.
   *
   * The number is calculated by formula (r+n-1)! / r! * (n - 1)!, where n -
   * number of elements to choose from and r - number of elements to choose.
   *
   * @param request
   *     the combinations request, see {@link CombinationsRequest}.
   * @param <T>
   *     the type of the elements in request.
   * @return the number of all possible combinations.
   */
  @Override
  public <T> int count(CombinationsRequest<T> request) {
    int ofSize = request.getOf()
        .size();
    int by = request.getBy();
    return Factorial.calculate(by + ofSize - 1)
        .intValue() / (Factorial.calculate(by)
        .intValue() * Factorial.calculate(ofSize - 1)
        .intValue());
  }

  /**
   * Generates a list of all possible combinations.
   *
   * The complexity: r*n!, where n - number of elements to choose from and r -
   * number of elements to choose.
   *
   * @param request
   *     the combination request, see {@link CombinationsRequest}.
   * @param <T>
   *     type of the elements in request.
   * @return the list of all possible combinations.
   */
  @Override
  public <T> List<List<T>> generate(CombinationsRequest<T> request) {
    List<T> combination = CombinationsUtils.createAndFillWithNull(
        request.getBy());
    List<List<T>> combinations = new ArrayList<>();
    generateHelper(request.getOf(), request.getBy(), 0, combination,
        combinations);
    return combinations;
  }

  private <T> void generateHelper(List<T> of, int by, int currentIndex,
      List<T> combination, List<List<T>> combinations) {

    if (currentIndex == by) {
      combinations.add(new ArrayList<>(combination));
      return;
    }

    for (int x = 0; x < of.size(); x++) {
      T elem = of.get(x);
      combination.set(currentIndex, elem);
      List<T> remainingOf = of.subList(x, of.size());
      generateHelper(remainingOf, by, currentIndex + 1, combination,
          combinations);
    }

  }
}

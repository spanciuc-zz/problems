package com.pantifik.problems.combinations;

import java.util.List;

/**
 * Defines methods to generate combinations of elements.
 */
interface CombinationsGenerator {

  /**
   * Calculates the number of possible combinations.
   *
   * @param request
   *     the combinations request, see {@link CombinationsRequest}.
   * @param <T>
   *     the type of the elements in request.
   * @return the number of all possible combinations.
   */
  <T> int count(CombinationsRequest<T> request);

  /**
   * Generates a list of all possible combinations.
   *
   * @param request
   *     the combination request, see {@link CombinationsRequest}.
   * @param <T>
   *     type of the elements in request.
   * @return the list of all possible combinations.
   */
  <T> List<List<T>> generate(CombinationsRequest<T> request);

}

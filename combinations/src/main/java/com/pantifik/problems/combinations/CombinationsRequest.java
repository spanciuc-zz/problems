package com.pantifik.problems.combinations;

import java.util.Collections;
import java.util.List;

/**
 * Holds the necessary data for combinations generation.
 *
 * @param <T>
 *     type of the elements to choose from.
 */
public class CombinationsRequest<T> {

  /**
   * The list of elements to choose from.
   */
  private final List<T> of;

  /**
   * The number of elements to choose.
   */
  private final int by;

  /**
   * Creates the combination request from given data.
   *
   * @param of
   *     the list of elements to choose from, must not be null or empyt.
   * @param by
   *     the number of elements to choose, must be in range [1, of.size()].
   * @throws IllegalArgumentException
   *     if list is null or empty, or number is not in range [1, of.size()].
   */
  CombinationsRequest(List<T> of, int by) {

    validateParamOf(of);

    validateParamBy(of.size(), by);

    this.of = of;
    this.by = by;
  }

  /**
   * Creates the request from given data, the number of elements to choose is
   * the size of the given list.
   *
   * @param of
   *     the list of elements to choose from.
   * @throws IllegalArgumentException
   *     if the list os null or empty.
   */
  CombinationsRequest(List<T> of) {

    validateParamOf(of);

    this.of = of;
    this.by = of.size();
  }

  /**
   * Creates the combination request from given data.
   *
   * @param of
   *     the list of elements to choose from, must not be null or empyt.
   * @param by
   *     the number of elements to choose, must be in range [1, of.size()].
   * @param <T>
   *     the type of the elements.
   * @return the created request.
   *
   * @throws IllegalArgumentException
   *     if list is null or empty, or number is not in range [1, of.size()].
   */
  public static <T> CombinationsRequest<T> of(List<T> of, int by) {
    return new CombinationsRequest<>(of, by);
  }

  /**
   * Creates the request from given data, the number of elements to choose is
   * the size of the given list.
   *
   * @param of
   *     the list of elements to choose from.
   * @param <T>
   *     the type of the elements.
   * @return the created request.
   *
   * @throws IllegalArgumentException
   *     if the list os null or empty.
   */
  public static <T> CombinationsRequest<T> of(List<T> of) {
    return new CombinationsRequest<>(of);
  }

  /**
   * Gets the list of elements to choose from for this request.
   * <p>
   * The list is an unmodifiable list.
   *
   * @return the list of elements to choose from for this request.
   */
  public List<T> getOf() {
    return Collections.unmodifiableList(of);
  }

  /**
   * Gets the number of elements to choose for this request.
   *
   * @return the number of elements to choose.
   */
  public int getBy() {
    return by;
  }

  private void validateParamBy(int size, int by) {
    if (by < 1 || by > size) {
      throw new IllegalArgumentException(
          "The 'by' number must be in range [1, from.size()]");
    }
  }

  private void validateParamOf(List<T> of) {
    if (of == null || of.isEmpty()) {
      throw new IllegalArgumentException("The list must not be null or empty");
    }
  }
}

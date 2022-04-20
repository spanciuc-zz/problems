package com.pantifik.problems.combinations;

import java.util.List;
import java.util.function.Supplier;

/**
 * Provides useful methods for combinations generation.
 */
public final class Combinations {

  /**
   * The default strategy used when one is not given, see {@link Type}
   */
  public static final Type DEFAULT_TYPE = Type.NO_REPETITIONS;

  private Combinations() {}

  /**
   * Calculates the number of possible combinations for default type of
   * combinations, see {@link #DEFAULT_TYPE}.
   *
   * @param of
   *     the list of elements to choose form, must not be null or empty.
   * @param by
   *     the number of elements to choose, must be in range [1, of.size()]
   * @return the number of possible combinations.
   *
   * @throws IllegalArgumentException
   *     if the parameter 'of' is null or empty, or if parameter 'by' is not in
   *     range [1, of.size()].
   */
  public static int count(final List<?> of, final int by) {
    return count(CombinationsRequest.of(of, by), DEFAULT_TYPE);
  }

  /**
   * Calculates the number of possible combinations for the given type of
   * combinations.
   *
   * @param of
   *     the list of elements to choose form, must not be null or empty.
   * @param by
   *     the number of elements to choose, must be in range [1, of.size()]
   * @param type
   *     the type of combinations, must be not null.
   * @return the number of possible combinations.
   *
   * @throws IllegalArgumentException
   *     if the parameter 'of' is null or empty, if parameter 'by' is not in
   *     range [1, of.size()], or parameter 'type' is null.
   */
  public static int count(final List<?> of, final int by, Type type) {
    return count(CombinationsRequest.of(of, by), type);
  }

  /**
   * Calculates the number of possible combinations for default type of
   * combinations, see {@link #DEFAULT_TYPE}.
   *
   * @param request
   *     the combination request, must be not null, see {@link
   *     CombinationsRequest}.
   * @return the number of possible combinations.
   *
   * @throws IllegalArgumentException
   *     if the parameter 'request' is null or invalid.
   */
  public static int count(final CombinationsRequest<?> request) {
    return count(request, DEFAULT_TYPE);
  }

  /**
   * Calculates the number of possible combinations for the given type of
   * combinations.
   *
   * @param request
   *     the combination request, must be not null, see {@link
   *     CombinationsRequest}.
   * @param type
   *     the type of combinations, must be not null.
   * @return the number of possible combinations.
   *
   * @throws IllegalArgumentException
   *     if the parameter 'request' is null or invalid or parameter 'type' is
   *     null.
   */
  public static int count(final CombinationsRequest<?> request, Type type) {
    validateType(type);
    return type.getGenerator()
        .count(request);
  }

  /**
   * Generates a list of possible combinations for default type of combinations,
   * see {@link #DEFAULT_TYPE}.
   *
   * @param of
   *     the list of elements to choose from, must not be null or empty.
   * @param by
   *     the number of elements to choose from, must be in range [1,
   *     of.size()].
   * @param <T>
   *     the type of the elements.
   * @return the list of possible combinations.
   *
   * @throws IllegalArgumentException
   *     if param 'of' is null or empty, param 'by' is not in range [1,
   *     of.size()].
   */
  public static <T> List<List<T>> generate(final List<T> of, final int by) {
    return generate(CombinationsRequest.of(of, by), DEFAULT_TYPE);
  }

  /**
   * Generates a list of possible combinations for the given type of
   * combinations.
   *
   * @param of
   *     the list of elements to choose from, must not be null or empty.
   * @param by
   *     the number of elements to choose from, must be in range [1,
   *     of.size()].
   * @param type
   *     the type of combinations, must not be null.
   * @param <T>
   *     the type of the elements.
   * @return the list of possible combinations.
   *
   * @throws IllegalArgumentException
   *     if param 'of' is null or empty, param 'by' is not in range [1,
   *     of.size()] or param 'type' is null.
   */
  public static <T> List<List<T>> generate(final List<T> of, final int by,
      Type type) {
    return generate(CombinationsRequest.of(of, by), type);
  }

  /**
   * Generates a list of possible combinations for default type of combinations,
   * see {@link #DEFAULT_TYPE}.
   *
   * @param request
   *     the combinations request, must not be null, see {@link
   *     CombinationsRequest}.
   * @param <T>
   *     the type of the elements.
   * @return the list of possible combinations.
   *
   * @throws IllegalArgumentException
   *     if param 'request' is null or invalid.
   */
  public static <T> List<List<T>> generate(
      final CombinationsRequest<T> request) {
    return generate(request, DEFAULT_TYPE);
  }

  /**
   * Generates a list of possible combinations for the given type of
   * combinations.
   *
   * @param request
   *     the combinations request, must not be null, see {@link
   *     CombinationsRequest}.
   * @param type
   *     the type of combinations, must not be null, see {@link
   *     CombinationsRequest}
   * @param <T>
   *     the type of the elements.
   * @return the list of possible combinations.
   *
   * @throws IllegalArgumentException
   *     if param 'request' is null or invalid or param 'type' is null.
   */
  public static <T> List<List<T>> generate(final CombinationsRequest<T> request,
      Type type) {
    validateType(type);
    return type.getGenerator()
        .generate(request);
  }

  private static void validateType(Type type) {
    if (type == null) {
      throw new IllegalArgumentException("The type must not be null");
    }
  }

  /**
   * Defines types of combinations.
   */
  public enum Type {
    /**
     * The combinations that do not allow repetitions.
     */
    NO_REPETITIONS(CombinationsWithoutRepetitions::new),
    /**
     * The combinations that allow repetitions.
     */
    WITH_REPETITIONS(CombinationsWithRepetitions::new);

    private final Supplier<CombinationsGenerator> generatorSupplier;

    Type(Supplier<CombinationsGenerator> generatorSupplier) {
      this.generatorSupplier = generatorSupplier;
    }

    /**
     * Gets the generator defined fot this type.
     *
     * @return the defined generator.
     */
    CombinationsGenerator getGenerator() {
      return this.generatorSupplier.get();
    }

  }

}

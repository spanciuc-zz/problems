package com.pantifik.problems.permutations;

import java.util.List;
import java.util.function.Supplier;

/**
 * Provides methods for permutations generation.
 */
public final class Permutations {

  /**
   * The default permutation type to be used when one was not given.
   */
  static Type defaultType = Type.NO_REPETITIONS;

  private Permutations() {}

  /**
   * Calculates number of possible permutations.
   *
   * <p>Uses the default permutation type, see {@link #defaultType}.
   *
   * @param from
   *     the elements to choose from.
   * @param count
   *     the number of elements to choose.
   * @return the number of total possible permutations.
   */
  public static int calculateCount(List<?> from, int count) {
    return calculateCount(from, count, defaultType);
  }

  /**
   * Calculates number of possible permutations.
   * <p>
   * Uses the permutation type given as an argument.
   *
   * @param from
   *     the elements to choose from.
   * @param count
   *     the number of elements to choose.
   * @param permutationType
   *     the permutation type to be used, see {@link Type}.
   * @return the number of total possible permutations.
   */
  public static int calculateCount(List<?> from, int count,
      Type permutationType) {

    if (permutationType == null) {
      throw new IllegalArgumentException(
          "The permutation type must not be null");
    }

    return permutationType.getPermutationsGenerator()
        .count(from, count);
  }

  /**
   * Generates all possible permutations.
   * <p>
   * Uses default permutations type, see {@link #defaultType}.
   *
   * @param from
   *     the elements to choose from.
   * @param count
   *     the number of elements to choose.
   * @param <T>
   *     the type of the elements.
   * @return A list with generated permutations.
   */
  public static <T> List<List<T>> generate(List<T> from, int count) {
    return generate(from, count, defaultType);
  }

  /**
   * Generates all possible permutations.
   *
   * @param from
   *     the elements to choose from.
   * @param count
   *     the number of elements to choose.
   * @param permutationType
   *     the type of permutation to be used, see {@link Type}.
   * @param <T>
   *     the type of the elements.
   * @return A list with generated permutations.
   */
  public static <T> List<List<T>> generate(List<T> from, int count,
      Type permutationType) {

    if (permutationType == null) {
      throw new IllegalArgumentException(
          "The permutation type must not be null");
    }

    return permutationType.getPermutationsGenerator()
        .generate(from, count);

  }

  /**
   * Defines methods for the different types of permutations.
   */
  public enum Type {
    /**
     * The permutations which do not allow the same element to be chosen more
     * than one time.
     */
    NO_REPETITIONS(PermutationsWithoutRepetitions::new),

    /**
     * The permutations which allow the same element to be chosen more than one
     * time.
     */
    WITH_REPETITIONS(PermutationsWithRepetitions::new);

    final Supplier<PermutationsGenerator> permutationsGeneratorSupplier;

    Type(Supplier<PermutationsGenerator> permutationsGeneratorSupplier) {
      this.permutationsGeneratorSupplier = permutationsGeneratorSupplier;
    }

    PermutationsGenerator getPermutationsGenerator() {
      return this.permutationsGeneratorSupplier.get();
    }

  }


}

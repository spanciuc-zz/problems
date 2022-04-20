package com.pantifik.problems.permutations;

import com.pantifik.problems.factorial.Factorial;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for working with string permutations without repetitions.
 */
public class StringPermutations {

  private StringPermutations() {}

  /**
   * Calculates number of possible permutations.
   *
   * <p>
   * The count of permutations without repetitions is calculated by the formula:
   * (n!) / (n - r)!,  where n - number of elements to choose from and r -
   * number of elements to  choose.
   *
   * @param from
   *     the string to choose characters from, must not be null or blank.
   * @param count
   *     the number of characters to choose, must be greater than 0 and less
   *     than 'from' size.
   * @return number of all possible permutations.
   *
   * @throws IllegalArgumentException
   *     if 'from' is null or blank, and count is less than 1 or greater than
   *     'from' length.
   */
  public static int count(final String from, final int count) {

    validateFrom(from);

    validateCount(from, count);

    int upperBound = from.length();
    int lowerBound = upperBound - count + 1;

    return Factorial.calculate(lowerBound, upperBound)
        .intValue();
  }

  /**
   * Generates all the possible permutations without repetitions.
   * <p>
   * Complexity n*n*n!, where n - elements to choose from and r - number of *
   * elements to choose.
   *
   * @param from
   *     the string to choose characters from, must not be null or blank.
   * @param count
   *     the number of character to choose, must be greater than 0 and less than
   *     'from' size.
   * @return a list of all possible permutations.
   *
   * @throws IllegalArgumentException
   *     if 'from' is null or blank, or count is less than 1 or greater than
   *     'from' length.
   */
  public static List<String> generate(final String from, final int count) {

    validateFrom(from);

    validateCount(from, count);

    List<String> permutations = new ArrayList<>();

    generateHelper(from, count, 0, new char[count], permutations);

    return permutations;
  }

  private static void generateHelper(String from, int count, int currentIndex,
      char[] permutation, List<String> permutations) {

    if (currentIndex == count) {
      permutations.add(new String(permutation));
      return;
    }

    for (int x = 0; x < from.length(); x++) {
      permutation[currentIndex] = from.charAt(x);
      String remainingFrom = from.substring(0, x) + from.substring(x + 1);
      generateHelper(remainingFrom, count, currentIndex + 1, permutation,
          permutations);
    }

  }

  private static void validateCount(String from, int count) {
    if (count < 1 || count > from.length()) {
      throw new IllegalArgumentException(
          "The 'count' must be > 0 and <= 'from' string");
    }
  }

  private static void validateFrom(String from) {
    if (from == null || from.isBlank()) {
      throw new IllegalArgumentException(
          "The 'from' string must not be null or empty");
    }
  }

}

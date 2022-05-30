package com.pantifik.problems.brackets.matcher;

public record Pair(char left, char right) {

  public static final String SAME_ELEMENTS_MESSAGE = "The pair's elements must not be the same.";

  public Pair {
    if (left == right) {
      throw new IllegalArgumentException(SAME_ELEMENTS_MESSAGE);
    }
  }
}

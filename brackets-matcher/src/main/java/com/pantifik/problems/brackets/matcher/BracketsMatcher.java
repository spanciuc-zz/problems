package com.pantifik.problems.brackets.matcher;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Provides methods to determine if a brackets string has a correct order.
 */
public class BracketsMatcher {

  public boolean check(String sequence, PairDictionary dictionary) {
    validateSequence(sequence);
    validateDictionary(dictionary);

    Deque<Character> stack = new LinkedList<>();

    for (var i = 0; i < sequence.length(); i++) {
      char current = sequence.charAt(i);
      if (dictionary.isLeft(current)) {
        stack.addFirst(current);
      } else if (dictionary.isRight(current)) {
        if (stack.isEmpty()) {
          return false;
        } else {
          char stackElem = stack.remove();
          boolean result = dictionary.getLeft(current)
              .map(e -> stackElem == e)
              .orElse(false);
          if (!result) {
            return false;
          }
        }
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }

  private void validateDictionary(PairDictionary dictionary) {
    Objects.requireNonNull(dictionary);
    if (dictionary.isEmpty()) {
      throw new IllegalArgumentException("The dictionary must not be empty");
    }
  }

  private void validateSequence(String sequence) {
    Objects.requireNonNull(sequence);
    if (sequence.isBlank()) {
      throw new IllegalArgumentException("The sequence must not be blank");
    }
  }

}

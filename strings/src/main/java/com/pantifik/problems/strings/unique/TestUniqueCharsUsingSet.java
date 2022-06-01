package com.pantifik.problems.strings.unique;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class TestUniqueCharsUsingSet implements TestUniqueChars {

  @Override
  public boolean check(String string) {
    Objects.requireNonNull(string);
    Set<Character> charSet = new HashSet<>();
    for (int x = 0; x < string.length(); x++) {
      if (!charSet.add(string.charAt(x))) {
        return false;
      }
    }
    return true;
  }

}

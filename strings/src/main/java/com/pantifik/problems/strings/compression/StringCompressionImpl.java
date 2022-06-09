package com.pantifik.problems.strings.compression;

import java.util.Objects;

public class StringCompressionImpl implements StringCompression {

  @Override
  public String compress(String text) {
    validateText(text);
    StringBuilder resultBuilder = new StringBuilder();
    int i = 1;
    int j = 1;
    char prev = text.charAt(0);
    boolean hasDuplicated = false;
    while (i < text.length()) {
      char current = text.charAt(i);
      if (current == prev) {
        hasDuplicated = true;
        j++;
      } else {
        appendCharAndCount(resultBuilder, prev, j);
        j = 1;
      }
      prev = current;
      i++;
    }
    appendCharAndCount(resultBuilder, prev, j);

    return hasDuplicated ? resultBuilder.toString() : text;
  }

  private void appendCharAndCount(StringBuilder resultBuilder, char c, int n) {
    resultBuilder.append(c);
    resultBuilder.append(n);
  }

  private void validateText(String text) {
    Objects.requireNonNull(text);
    if (!text.matches("^[a-zA-Z]+$")) {
      throw new IllegalArgumentException(
          "The text must contains only only uppercase and lowercase letters (a - z)");
    }

  }
}

package com.pantifik.problems.strings.unique;

/**
 * The approach is valid for strings having only characters A-Z a-z 0-9.
 */
public class TestUniqueCharsUsingBitwise implements TestUniqueChars {

  public static final String NOT_IN_RANGE_MESSAGE = "The value is not in range: %s";

  @Override
  public boolean check(String string) {
    long checker = 0L;
    for (int i = 0; i < string.length(); i++) {
      int index = normalizeIndex(string.charAt(i));
      long bitIndex = 1L << index;
      if ((checker & bitIndex) > 0) {
        return false;
      }
      checker |= bitIndex;
    }
    return true;
  }

  int normalizeIndex(int value) {
    validateChar(value);
    int offset = '0';
    if (value > 'Z') {
      offset += 'a' - 'Z';
    }
    if (value > '9') {
      offset += ('A' - '9') - 1;
    }
    return value - offset;
  }

  private void validateChar(int value) {
    if (isInRange(value, '0', '9') || isInRange(value, 'A', 'Z') || isInRange(value, 'a', 'z')) {
      return;
    }
    throw new IllegalArgumentException(String.format(NOT_IN_RANGE_MESSAGE, value));
  }

  private boolean isInRange(int value, int from, int to) {
    return value >= from && value <= to;
  }
}

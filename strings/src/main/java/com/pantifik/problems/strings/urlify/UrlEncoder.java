package com.pantifik.problems.strings.urlify;

import java.util.Objects;

public class UrlEncoder {

  public static final char SPACE_CHAR = ' ';
  public static final String SPACE_ENCODED = "%20";

  private UrlEncoder() {}

  public static String encode(String text) {
    Objects.requireNonNull(text);
    int spacesCount = getSpacesCount(text);
    int encodedLength = calculateArraySize(text.length(), spacesCount);
    char[] arr = new char[encodedLength];
    System.arraycopy(text.toCharArray(), 0, arr, 0, text.length());
    doEncode(arr, text.length());
    return new String(arr);
  }

  private static void doEncode(char[] arr, int textLength) {
    int encodedIndex = arr.length - 1;
    for (int i = textLength - 1; i >= 0; i--) {
      encodedIndex = encodeChar(arr, arr[i], encodedIndex);
    }
  }

  private static int encodeChar(char[] arr, char toEncode, int encodedIndex) {
    return switch (toEncode) {
      case SPACE_CHAR -> addEncodedSpace(arr, encodedIndex);
      default -> addChar(arr, toEncode, encodedIndex);
    };
  }

  private static int addEncodedSpace(char[] arr, int index) {
    arr[index--] = '0';
    arr[index--] = '2';
    arr[index--] = '%';
    return index;
  }

  private static int addChar(char[] arr, char toAdd, int index) {
    arr[index--] = toAdd;
    return index;
  }

  private static int getSpacesCount(String text) {
    return (int) text.chars()
        .filter(c -> c == SPACE_CHAR)
        .count();
  }

  private static int calculateArraySize(int textLength, int spacesCount) {
    return textLength + (spacesCount * 2);
  }

}

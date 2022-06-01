package com.pantifik.problems.strings.unique;

import java.util.Arrays;

public class TestUniqueCharsUsingBinaryInsertion implements TestUniqueChars {

  @Override
  public boolean check(String string) {
    char[] arr = string.toCharArray();

    for (int i = 1; i < arr.length; i++) {

      char current = arr[i];

      int j = Arrays.binarySearch(arr, 0, i, current);

      if (j >= 0) {
        return false;
      } else {
        j = Math.abs(j + 1);
        System.arraycopy(arr, j, arr, j + 1, i - j);
        arr[j] = current;
      }

    }
    return true;
  }
}

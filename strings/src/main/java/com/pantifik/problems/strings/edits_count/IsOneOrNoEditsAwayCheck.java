package com.pantifik.problems.strings.edits_count;

import java.util.Objects;

public class IsOneOrNoEditsAwayCheck {

  public static final int MAX_EDIT_COUNT = 1;
  public static final int MIN_EDIT_COUNT = 0;

  private IsOneOrNoEditsAwayCheck() {
  }

  public static boolean check(String first, String second) {
    Objects.requireNonNull(first, second);

    int firstLength = first.length();
    int secondLength = second.length();

    int diffsLength = Math.abs(firstLength - secondLength);

    if (diffsLength > MAX_EDIT_COUNT) {
      return false;
    }

    int editCount = MIN_EDIT_COUNT;
    int i = 0;
    int j = 0;
    while (i < firstLength && j < secondLength) {
      if (first.charAt(i) == second.charAt(j)) {
        i++;
        j++;
      } else {
        editCount++;
        if (editCount > MAX_EDIT_COUNT) {
          return false;
        }
        if (firstLength > secondLength) {
          i++;
        } else if (firstLength < secondLength) {
          j++;
        } else {
          i++;
          j++;
        }
      }
    }

    if (i < firstLength || j < secondLength) {
      editCount++;
    }

    return editCount == MIN_EDIT_COUNT || editCount == MAX_EDIT_COUNT;
  }

}

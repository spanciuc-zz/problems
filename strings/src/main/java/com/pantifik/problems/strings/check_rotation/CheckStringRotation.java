package com.pantifik.problems.strings.check_rotation;

import java.util.Objects;

/**
 * Provides methods to check whether a string is a rotation of another one.
 */
public class CheckStringRotation {

    private CheckStringRotation() {
    }

    /**
     * Checks whether a string is a rotation of another string.
     *
     * @param str1 the string assumed to be a rotation.
     * @param str2 the original string.
     * @return true if str1 is a rotation of str2, otherwise - false.
     */
    public static boolean isRotation(String str1, String str2) {
        Objects.requireNonNull(str1);
        Objects.requireNonNull(str2);
        String temp = str1 + str1;
        return isSubstring(str2, temp);
    }

    private static boolean isSubstring(String str1, String str2) {
        return str2.contains(str1);
    }
}

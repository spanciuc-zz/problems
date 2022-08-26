package com.pantifik.problems.strings.check_rotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CheckStringRotationTest {

    public static Stream<Arguments> isRotationNullsProvider() {
        return Stream.of(Arguments.of(null, "asd"), Arguments.of("123", null), Arguments.of(null, null));
    }

    @ParameterizedTest
    @MethodSource("isRotationNullsProvider")
    void isRotation_whenNulls_shouldThrowException(String str1, String str2) {
        assertThrows(NullPointerException.class, () -> CheckStringRotation.isRotation(str1, str2));
    }

    @ParameterizedTest
    @CsvSource({"cdab, abcd", "erbottlewat, waterbottle", "1234, 1234"})
    void isRotation_whenIsRotation_shouldReturnTrue(String str1, String str2) {
        assertTrue(CheckStringRotation.isRotation(str1, str2));
    }

    @ParameterizedTest
    @CsvSource({"cdab, dbca", "1234, 12356", "1234, 1243"})
    void isRotation_whenIsNotRotation_shouldReturnFalse(String str1, String str2) {
        assertFalse(CheckStringRotation.isRotation(str1, str2));
    }
}
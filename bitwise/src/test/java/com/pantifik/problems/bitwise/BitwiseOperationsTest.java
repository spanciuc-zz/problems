package com.pantifik.problems.bitwise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BitwiseOperationsTest {

  public static Stream<Arguments> andProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(0b0, 0b0, 0b0));
    arguments.add(Arguments.of(0b0, 0b0, 0b1));
    arguments.add(Arguments.of(0b1, 0b1, 0b1));
    arguments.add(Arguments.of(0b10, 0b11, 0b10));
    return arguments.stream();
  }

  public static Stream<Arguments> orProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(0b0, 0b0, 0b0));
    arguments.add(Arguments.of(0b1, 0b0, 0b1));
    arguments.add(Arguments.of(0b1, 0b1, 0b1));
    arguments.add(Arguments.of(0b11, 0b11, 0b10));
    return arguments.stream();
  }

  public static Stream<Arguments> xorProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(0b0, 0b0, 0b0));
    arguments.add(Arguments.of(0b1, 0b0, 0b1));
    arguments.add(Arguments.of(0b0, 0b1, 0b1));
    arguments.add(Arguments.of(0b01, 0b11, 0b10));
    return arguments.stream();
  }

  public static Stream<Arguments> notProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(-1, 0));
    arguments.add(Arguments.of(-2, 1));
    arguments.add(Arguments.of(-3, 0b10));
    arguments.add(Arguments.of(-4, 0b11));
    return arguments.stream();
  }

  public static Stream<Arguments> leftShiftProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(0b0, 0b0, 0b1));
    arguments.add(Arguments.of(0b0, 0b0, 0b1));
    arguments.add(Arguments.of(0b10, 0b1, 0b1));
    arguments.add(Arguments.of(0b1100, 0b11, 0b10));
    arguments.add(Arguments.of(-0b11110000, -0b1111, 0b100));
    return arguments.stream();
  }

  public static Stream<Arguments> rightShiftProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(0b0, 0b0, 0b1));
    arguments.add(Arguments.of(0b0, 0b0, 0b1));
    arguments.add(Arguments.of(0b0, 0b1, 0b1));
    arguments.add(Arguments.of(0b00, 0b11, 0b10));
    arguments.add(Arguments.of(0b110, 0b11000, 0b10));
    arguments.add(Arguments.of(-0b1111, -0b11110000, 0b100));
    return arguments.stream();
  }

  public static Stream<Arguments> unsignedRightShiftProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(0b0, 0b0, 0b1));
    arguments.add(Arguments.of(0b0, 0b0, 0b1));
    arguments.add(Arguments.of(0b0, 0b1, 0b1));
    arguments.add(Arguments.of(0b00, 0b11, 0b10));
    arguments.add(Arguments.of(0b110, 0b11000, 0b10));
    arguments.add(Arguments.of(3, 12, 2));
    arguments.add(Arguments.of(1073741821, -12, 2));
    return arguments.stream();
  }

  @ParameterizedTest
  @MethodSource("andProvider")
  void and_shouldReturnResult(int expected, int a, int b) {
    assertEquals(expected, BitwiseOperations.and(a, b));
  }

  @ParameterizedTest
  @MethodSource("orProvider")
  void or_shouldReturnResult(int expected, int a, int b) {
    assertEquals(expected, BitwiseOperations.or(a, b));
  }

  @ParameterizedTest
  @MethodSource("xorProvider")
  void xor_shouldReturnResult(int expected, int a, int b) {
    assertEquals(expected, BitwiseOperations.xor(a, b));
  }

  @ParameterizedTest
  @MethodSource("notProvider")
  void not_shouldReturnResult(int expected, int a) {
    assertEquals(expected, BitwiseOperations.not(a));
  }

  @ParameterizedTest
  @MethodSource("leftShiftProvider")
  void leftShift_shouldReturnResult(int expected, int a, int b) {
    assertEquals(expected, BitwiseOperations.leftShift(a, b));
  }

  @ParameterizedTest
  @MethodSource("rightShiftProvider")
  void rightShift_shouldReturnResult(int expected, int a, int b) {
    assertEquals(expected, BitwiseOperations.rightShift(a, b));
  }

  @ParameterizedTest
  @MethodSource("unsignedRightShiftProvider")
  void unsignedRightShift_shouldReturnResult(int expected, int a, int b) {
    assertEquals(expected, BitwiseOperations.unsignedRightShift(a, b));
  }

}
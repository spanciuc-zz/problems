package com.pantifik.problems.arrays.rotate_matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SquareMatrixRightRotatorUsingSubSquaresTest {

  private MatrixRotator rotator;

  public static Stream<Arguments> rotateProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(new int[][]{{1, 2}, {3, 4}}, new int[][]{{3, 1}, {4, 2}}));
    arguments.add(Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
        new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}));
    arguments.add(
        Arguments.of(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
            new int[][]{{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}}));
    return arguments.stream();
  }

  @BeforeEach
  void setUp() {
    this.rotator = new SquareMatrixRightRotatorUsingSubSquares();
  }

  @ParameterizedTest
  @MethodSource("rotateProvider")
  void rotate_shouldRotateMatrixToTheRight(int[][] matrix, int[][] expected) {
    assertArrayEquals(expected, rotator.rotate(matrix));
  }

}
package com.pantifik.problems.arrays.transpose_matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SquareMatrixTransposeTest {

  private MatrixTranspose matrixTranspose;

  public static Stream<Arguments> rotateProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 3}, {2, 4}}));
    arguments.add(Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
        new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}));
    arguments.add(Arguments.of(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
        new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16}}));
    return arguments.stream();
  }

  @BeforeEach
  void setUp() {
    this.matrixTranspose = new SquareMatrixTranspose();
  }

  @ParameterizedTest
  @MethodSource("rotateProvider")
  void rotate_shouldRotateMatrixToTheRight(int[][] matrix, int[][] expected) {
    assertArrayEquals(expected, matrixTranspose.transpose(matrix));
  }


}
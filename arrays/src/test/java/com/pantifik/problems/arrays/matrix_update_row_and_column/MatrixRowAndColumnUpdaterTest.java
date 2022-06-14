package com.pantifik.problems.arrays.matrix_update_row_and_column;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class MatrixRowAndColumnUpdaterTest {

  protected MatrixRowAndColumnUpdater matrixUpdater;

  public static Stream<Arguments> setRowAndColumnIfProvider() {
    return Stream.of(Arguments.of(new int[][]{}, new int[][]{}),
        Arguments.of(new int[][]{{1, 2, 3}}, new int[][]{{1, 2, 3}}),
        Arguments.of(new int[][]{{1, 2, 0}}, new int[][]{{0, 0, 0}}),
        Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{1, 2, 3}, {4, 5, 6}}),
        Arguments.of(new int[][]{{0, 2, 3}, {1, 0, 100}, {1, 19, 29}, {1, 2, 0}},
            new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}),
        Arguments.of(new int[][]{{0, 2, 3}, {1, 12, 100}, {1, 19, 29}, {1, 2, 3}},
            new int[][]{{0, 0, 0}, {0, 12, 100}, {0, 19, 29}, {0, 2, 3}},
            Arguments.of(new int[][]{{1, 4, 3}, {1, 4, 100}, {1, 0, 29}, {1, 2, 3}},
                new int[][]{{1, 0, 3}, {1, 0, 100}, {0, 0, 0}, {1, 0, 3}})));
  }

  protected abstract MatrixRowAndColumnUpdater createInstance();

  @BeforeEach
  void setUp() {
    this.matrixUpdater = createInstance();
  }

  @Test
  void setRowAndColumnIf_whenArrayIsNull_shouldThrowException() {
    assertThrows(NullPointerException.class,
        () -> matrixUpdater.setRowAndColumnIf(null, 0, (x) -> true));
  }

  @Test
  void setRowAndColumnIf_whenPredicateIsNull_shouldThrowException() {
    assertThrows(NullPointerException.class,
        () -> matrixUpdater.setRowAndColumnIf(new int[][]{{1}, {2}}, 0, null));
  }

  @ParameterizedTest
  @MethodSource("setRowAndColumnIfProvider")
  void setRowAndColumnIf_whenValidParams_shouldSetRowAndColumnValueIfValueIsPresent(int[][] matrix,
      int[][] expected) {
    matrixUpdater.setRowAndColumnIf(matrix, 0, (value) -> value == 0);
    assertArrayEquals(expected, matrix);
  }
}
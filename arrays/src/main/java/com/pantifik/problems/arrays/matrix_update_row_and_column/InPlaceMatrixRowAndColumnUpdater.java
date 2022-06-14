package com.pantifik.problems.arrays.matrix_update_row_and_column;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;

public class InPlaceMatrixRowAndColumnUpdater implements MatrixRowAndColumnUpdater {

  @Override
  public int[][] setRowAndColumnIf(int[][] matrix, int value, IntPredicate predicate) {
    Objects.requireNonNull(matrix);
    Objects.requireNonNull(predicate);

    RowAndColumnFlag rowAndColumnFlag = setFirstRowAndColumnValueIf(matrix, value, predicate);

    setMatrixValueIfRowOrColumnIf(matrix, value, predicate);

    if (rowAndColumnFlag.row()) {
      setFirstRowValue(matrix, value);
    }

    if (rowAndColumnFlag.column()) {
      setFirstColumnValue(matrix, value);
    }

    return matrix;
  }

  private RowAndColumnFlag setFirstRowAndColumnValueIf(int[][] matrix, int value,
      IntPredicate predicate) {
    boolean firstRow = false;
    boolean firstColumn = false;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (predicate.test(matrix[i][j])) {
          if (i == 0) {
            firstRow = true;
          }
          if (j == 0) {
            firstColumn = true;
          }
          matrix[0][j] = value;
          matrix[i][0] = value;
        }
      }
    }
    return new RowAndColumnFlag(firstRow, firstColumn);
  }

  private void setMatrixValueIfRowOrColumnIf(int[][] matrix, int value, IntPredicate predicate) {
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (predicate.test(matrix[0][j]) || predicate.test(matrix[i][0])) {
          matrix[i][j] = value;
        }
      }
    }
  }

  private void setFirstColumnValue(int[][] matrix, int value) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][0] = value;
    }
  }

  private void setFirstRowValue(int[][] matrix, int value) {
    Arrays.fill(matrix[0], value);
  }

  private record RowAndColumnFlag(boolean row, boolean column) {}
}

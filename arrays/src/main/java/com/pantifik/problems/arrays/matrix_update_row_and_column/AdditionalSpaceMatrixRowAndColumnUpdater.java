package com.pantifik.problems.arrays.matrix_update_row_and_column;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.IntPredicate;

public class AdditionalSpaceMatrixRowAndColumnUpdater implements MatrixRowAndColumnUpdater {

  @Override
  public int[][] setRowAndColumnIf(int[][] matrix, int value, IntPredicate predicate) {
    Objects.requireNonNull(matrix);
    Objects.requireNonNull(predicate);

    Set<Integer> matchingRows = new HashSet<>();
    Set<Integer> matchingColumns = new HashSet<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (predicate.test(matrix[i][j])) {
          matchingRows.add(i);
          matchingColumns.add(j);
        }
      }
    }

    matchingRows.forEach(r -> setRowValue(matrix, r, 0));
    matchingColumns.forEach(c -> setColumnValue(matrix, c, 0));

    return matrix;
  }

  private static void setRowValue(int[][] matrix, int rowIndex, int value) {
    Arrays.fill(matrix[rowIndex], value);
  }

  private static void setColumnValue(int[][] matrix, int columnIndex, int value) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][columnIndex] = value;
    }
  }

}

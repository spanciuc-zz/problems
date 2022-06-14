package com.pantifik.problems.arrays.matrix_update_row_and_column;

import java.util.function.IntPredicate;

public interface MatrixRowAndColumnUpdater {

  int[][] setRowAndColumnIf(int[][] matrix, int value, IntPredicate predicate);

}

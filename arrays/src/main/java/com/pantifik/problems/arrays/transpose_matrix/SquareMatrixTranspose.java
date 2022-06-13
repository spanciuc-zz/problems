package com.pantifik.problems.arrays.transpose_matrix;

public class SquareMatrixTranspose implements MatrixTranspose {

  @Override
  public int[][] transpose(int[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[i].length; j++) {
        if (i != j) {
          int temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
        }
      }
    }

    return matrix;
  }
}

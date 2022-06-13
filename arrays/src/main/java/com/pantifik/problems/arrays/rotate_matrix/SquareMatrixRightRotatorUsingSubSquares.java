package com.pantifik.problems.arrays.rotate_matrix;

public class SquareMatrixRightRotatorUsingSubSquares implements MatrixRotator {

  @Override
  public int[][] rotate(int[][] matrix) {
    int subSquaresCount = matrix.length / 2;

    for (int i = 0; i < subSquaresCount; i++) {
      int iFromEnd = matrix.length - 1 - i;
      for (int j = i; j < iFromEnd; j++) {
        int jFromEnd = matrix.length - 1 - j;

        int temp = matrix[i][j];

        // move left column to top row
        matrix[i][j] = matrix[jFromEnd][i];

        //move bottom row to left column
        matrix[jFromEnd][i] = matrix[iFromEnd][jFromEnd];

        //move right column to bottom row
        matrix[iFromEnd][jFromEnd] = matrix[j][iFromEnd];

        //move top row to right column
        matrix[j][iFromEnd] = temp;


      }

    }

    return matrix;

  }
}

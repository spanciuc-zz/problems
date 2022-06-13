package com.pantifik.problems.arrays.rotate_matrix;

import com.pantifik.problems.arrays.transpose_matrix.MatrixTranspose;

public class SquareMatrixRightRotatorUsingTranspose implements MatrixRotator {

  private final MatrixTranspose matrixTranspose;

  public SquareMatrixRightRotatorUsingTranspose(MatrixTranspose matrixTranspose) {
    this.matrixTranspose = matrixTranspose;
  }

  @Override
  public int[][] rotate(int[][] matrix) {
    matrix = matrixTranspose.transpose(matrix);
    for (int[] ints : matrix) {
      reverseArray(ints);
    }
    return matrix;
  }

  private void reverseArray(int[] array) {
    int lastIndex = array.length - 1;
    for (int i = 0; i < array.length / 2; i++) {
      swap(array, i, lastIndex - i);
    }
  }

  private void swap(int[] array, int from, int to) {
    int temp = array[from];
    array[from] = array[to];
    array[to] = temp;
  }
}

package com.pantifik.problems.arrays.matrix_update_row_and_column;

class InPlaceMatrixRowAndColumnUpdaterTest extends MatrixRowAndColumnUpdaterTest {

  @Override
  protected MatrixRowAndColumnUpdater createInstance() {
    return new InPlaceMatrixRowAndColumnUpdater();
  }
}
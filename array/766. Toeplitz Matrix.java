class Solution {
  private boolean checkValidDiagonal(int[][] matrix, int currRow, int currCol,
          int row, int col, int prevVal) {

      if (currRow == row || currCol == col) {
          return true;
      }

      if (matrix[currRow][currCol] != prevVal) {
          return false;
      }

      return checkValidDiagonal(matrix, currRow + 1, currCol + 1, row, col, matrix[currRow][currCol]);
  }

  public boolean isToeplitzMatrix(int[][] matrix) {
      int row = matrix.length;
      int col = matrix[0].length;

      if (row == 1 || col == 1) {
          return true;
      }

      for (int currRow = row - 1; currRow >= 1; currRow--) {
          if (!checkValidDiagonal(matrix, currRow, 0, row, col, matrix[currRow][0]))
              return false;
      }

      for (int currCol = 0; currCol < col; currCol++) {
          if (!checkValidDiagonal(matrix, 0, currCol, row, col, matrix[0][currCol])) {
              return false;
          }
      }

      return true;
  }
}
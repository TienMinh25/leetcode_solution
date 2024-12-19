class Solution {
  public int[][] matrixReshape(int[][] mat, int r, int c) {
      int rowMat = mat.length;
      int colMat = mat[0].length;

      if (rowMat * colMat != r * c)
          return mat;

      int[][] result = new int[r][c];

      int i = 0, j = 0;

      for (int m = 0; m < rowMat; m++) {
          for (int n = 0; n < colMat; n++) {
              result[i][j] = mat[m][n];
              j++;

              if (j == c) {
                  i++;
                  j = 0;
              }
          }
      }

      return result;
  }
}
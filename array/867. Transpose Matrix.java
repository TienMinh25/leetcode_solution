class Solution {
  public int[][] transpose(int[][] matrix) {
      int row = matrix.length, col = matrix[0].length;

      int[][] result = new int[col][row];

      for (int idxRowMatrix = 0; idxRowMatrix < row; idxRowMatrix++) {
          for (int idxColMatrix = 0; idxColMatrix < col; idxColMatrix++) {
              result[idxColMatrix][idxRowMatrix] = matrix[idxRowMatrix][idxColMatrix];
          }
      }

      return result;
  }
}
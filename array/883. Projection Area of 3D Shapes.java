class Solution {
  public int projectionArea(int[][] grid) {
      // side x, y -> count number of element in grid
      // side x, z -> sum(max value for every row)
      // side y, z -> sum(max value for every col)
      int res = 0, n = grid.length;
      for (int i = 0; i < n; ++i) {
          int x = 0, y = 0;
          for (int j = 0; j < n; ++j) {
              x = Math.max(x, grid[i][j]);
              y = Math.max(y, grid[j][i]);
              if (grid[i][j] > 0) ++res;
          }
          res += x + y;
      }
      return res;
  }
}
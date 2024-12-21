class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int val = image[sr][sc];
      dfs(image, sr, sc, color, val);

      return image;
  }

  public void dfs(int[][] image, int row, int col, int newColor, int val) {
      if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] == newColor
              || image[row][col] != val) {
          return;
      }

      image[row][col] = newColor;
      dfs(image, row - 1, col, newColor, val);
      dfs(image, row, col + 1, newColor, val);
      dfs(image, row, col - 1, newColor, val);
      dfs(image, row + 1, col, newColor, val);
  }
}
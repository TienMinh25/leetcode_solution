/**
 * Phân tích bài toán:
 * Cho mảng 2 chiều m hàng n cột với các number đều là số >= 0
 * Tìm tổng min của path từ top left đến bottom right
 * 
 * B1: Xác định trạng thái bài toán
 * Gọi dp[i][j] là tổng min path nhỏ nhất khi đến hàng i cột j
 * ==> dp[i][j] là trạng thái
 * 
 * B2: Liên hệ giữa các trạng thái
 * Ta thấy rằng: việc đi được đến ô hàng i cột j, ta có 2 cách:
 * + Đi từ trái sang
 * + Đi từ trên xuống
 * ==> dp[i][j] = min(dp[i - 1][j] + a[i - 1][j - 1], dp[i][j - 1] +
 * a[i-1][j-1]);
 * với 1 <= i,j <= m,n
 * 
 * B3: Xác định kết quả
 */
class Solution {
  public int minPathSum(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      int[][] dp = new int[n + 1][m + 1];

      for (int i = 0; i <= n; i++)
          dp[i][0] = Integer.MAX_VALUE;

      for (int i = 0; i <= m; i++)
          dp[0][i] = Integer.MAX_VALUE;

      for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= m; j++) {
              if (i == 1 && j == 1) {
                  dp[i][j] = grid[i - 1][j - 1];
              } else {
                  dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
              }
          }
      }

      return dp[n][m];
  }
}
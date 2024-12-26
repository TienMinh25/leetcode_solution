/**
Solution: sử dụng kĩ thuật quy hoạch động

B1: Xác định trạng thái bài toán
Gọi dp[i][j] là số cách đi đến ô có hàng i cột j mà không vướng phải chướng ngại vật nào
(với 0 <= i <= m, 0 <= j <= n)

B2: Liên hệ trạng thái bài toán
Ta nhận thấy để đi đến 1 ô, ta có 2 cách: đi từ trái sang hoặc đi từ trên xuống
Nhưng ở đây nếu ô nào có đá thì ô đó sẽ là 0 có cách đi đến
==> công thức là:
{
    dp[i][j] = 0 nếu grid[i][j] = 0
    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
}

B3: Xác định kết quả
dp[m][n]
*/
class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int row = obstacleGrid.length;
      int col = obstacleGrid[0].length;

      int[][] dp = new int[row + 1][col + 1];

      for (int i = 1; i <= row; i++) {
          for (int j = 1; j <= col; j++) {
              if (obstacleGrid[i - 1][j - 1] == 1) {
                  dp[i][j] = 0;
              } else {
                  if (i == 1 && j == 1) {
                      dp[i][j] = 1;
                  } 
                  else {
                      dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                  }
              }
          }
      }

      return dp[row][col];
  }
}
/*
Solution: Sử dụng kĩ thuật dynamic programming
B1: Xác định trạng thái bài toán
Gọi dp[i][j] là số cách khác nhau để đi đến được hàng i cột j, với 0 <= i <= m, 0 <= j <= n
Trạng thái bài toán là dp[i][j]

B2: Liên hệ trạng thái (liên hệ bài toán lớn và bài toán con)
Vì chỉ có 2 cách để đi từ trên xuống hoặc trái sang
===> dp[i][j] = dp[i-1][j] + dp[i][j - 1]

Ngoài ra, ta thấy với vị trí hàng 0 cột 0 thì chỉ có 1 cách để đi đến thôi

B3: Xác định kết quả bài toán
Vì là số cách di đến ô m và n ==> dp[m][n]

Độ phức tạp về cả time lẫn space: O(m*n)
*/
class Solution {
  public int uniquePaths(int m, int n) {
      int[][] dp = new int[m + 1][n + 1];

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (i == 1 && j == 1) {
                  dp[i][j] = 1;
              } else {
                  dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
              }
          }
      }

      return dp[m][n];
  }
}
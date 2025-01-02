/**
 * B1: Xác định trạng thái bài toán
 * Phát biểu lại dưới dạng bài toán nhỏ hơn để xác định trạng thái
 * 
 * Gọi Ai là xâu gồm i kí tự đầu tiên của xâu A
 * Gọi Bj là xâu gồm j kí tự đầu tiên của xâu B
 * 
 * ==> đặt dp[i][j] là số phép biến đổi ít nhất để biến đổi xâu Ai thành xâu Bj
 * 
 * B2: Liên hệ trạng thái
 * Có 2 TH lớn có thể xảy ra:
 * TH1: A[i] == B[j] == 'C'
 * Cần biến đổi xâu A(i - 1)'C' thành xâu B(j - 1)'C'
 * ==> Để biến đổi tối ưu, cần biến đổi xâu A(i-1) thành xâu B(j-1) sau ít phép
 * biến đổi nhất
 * ==> dp[i][j] = dp[i - 1][j - 1]
 * 
 * TH2: A[i] = 'C' != B[j] = 'D'
 * Để biến đổi A(i - 1)'C' thành B(j - 1)'D', ta có các cách sau:
 * - Xoá kí tự C: Sau khi xoá, ta cần biến đổi xâu A(i - 1) thành B(j-1)'D', mà
 * số phép biến đổi ít nhất
 * xâu A(i-1) thành xâu B(j - 1)'D' là dp[i - 1][j]
 * ==> dp[i][j] = dp[i - 1][j] + 1
 * 
 * - Thay đổi kí tự C thành kí tự D:
 * Ta cần biến đổi xâu A(i - 1)'C' thành xâu B(j - 1)'D'
 * Mà số phép biến đổi ít nhất từ xâu A(i - 1) sang B(j - 1) là dp[i - 1][j - 1]
 * ==> dp[i][j] = dp[i - 1][j - 1] + 1;
 * 
 * - Chèn kí tự D sau kí tự C:
 * Lúc này xâu ban đầu bên Ai: A(i - 1)'C''D'
 * Xâu bên Bj: B(j - 1)'D'
 * Ta cần biến đổi xâu A(i - 1)'C' thành xâu B(j - 1) --> số phép biến đổi ít
 * nhất là dp[i][j - 1]
 * dp[i][j] = dp[i][j - 1] + 1
 * 
 * ==> Công thức bài toán:
 * dp[i][0] = i
 * dp[0][j] = j
 * dp[i][j] = dp[i - 1][j - 1] nếu A[i] = B[j]
 * dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
 * 
 * B3: Xác định kết quả
 * dp[m][n]
 * -> Chuỗi con xâu Am đến Bn
 */
class Solution {
  public int minDistance(String word1, String word2) {
      int m = word1.length(), n = word2.length();

      int[][] dp = new int[m + 1][n + 1];

      for (int i = 0; i <= m; i++)
          dp[i][0] = i;

      for (int j = 0; j <= n; j++)
          dp[0][j] = j;

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1];
              } else {
                  dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
              }
          }
      }

      return dp[m][n];
  }
}
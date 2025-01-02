/**
 * B1: Xác định trạng thái bài toán:
 * Gọi dp[i][j] là chi phí nhỏ nhất để đến được ô hàng i cột j (0 <= i < n)
 * dp[i][j] là trạng thái bài toán
 * 
 * B2: Liên hệ trạng thái bài toán
 * Ta nhận thấy: ở mỗi bước, ta chỉ có thể đi xuống (đi xuống có 2 cách)
 * xuống ở index i hoặc i + 1
 * dp[i][j] += min(triagle[i - 1][j], triagle[i - 1][j - 1])
 * dp[i][j] = min(triagle[i][j] + dp[i - 1][j], dp[i - 1][j - 1] +
 * triagle[i][j])
 * B3: Xác định kết quả bài toán:
 * min(dp[n - 1][j])
 * 
 * Ta nhận thấy, vì việc tính toán chỉ cần sử dụng lại cái hàng từ trước đó
 * ==> Ta có thể tối ưu việc lưu trữ
 * 
 * Ta không cần lưu trữ i nữa ==> lúc này ta chỉ còn cần code cho dp[j]
 */
class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
      // original
      /*
      int row = triangle.size();

      int[][] dp = new int[row][row];
      dp[0][0] = triangle.get(0).get(0);

      for (int i = 1; i < row; i++) {
          int col = triangle.get(i).size();

          for (int j = 0; j < col; j++) {
              if (j > 0 && j < col - 1) {
                  dp[i][j] = Math.min(dp[i - 1][j],
                          dp[i - 1][j - 1]) + triangle.get(i).get(j);
              } else if (j == 0) {
                  dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
              } else {
                  dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
              }
          }
      }

      var result = Integer.MAX_VALUE;

      for (int i = 0; i < row; i++) {
          result = Math.min(result, dp[row - 1][i]);
      }

      return result;
      */

      // after optimize
      // How optimize: với mỗi cột, ta đều có thể sử dụng lại, bởi vì mỗi bước đều
      // được tối ưu
      // kết quả bởi dp[i - 1][j] và dp[i - 1][j - 1]
      int row = triangle.size();
      int[] memo = new int[row];

      for (int i = 0; i < row; i++) {
          memo[i] = triangle.get(row - 1).get(i);
      }

      for (int r = row-2; r >= 0; r--) {
          for (int c = 0; c <= r; c++) {
              memo[c] = Math.min(memo[c], memo[c+1]) + triangle.get(r).get(c);
          }
      }

      return memo[0];
  }
}
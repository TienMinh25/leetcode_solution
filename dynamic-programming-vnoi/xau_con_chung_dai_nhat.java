/**
 * Đề bài: Cho 2 xâu A và B. Tìm xâu con chung dài nhất của A và B
 * Constraints:
 * 1 <= |A| * |B| <= 10^6
 * 
 * B1: Xác định trạng thái bài toán:
 * Gọi Ai là xâu gồm i kí tự đầu của A
 * Gọi Bj là xâu gồm j kí tự đầu của B
 * ==> A0 và B0 là xâu rỗng
 * 
 * Ý tưởng như bài biến đổi xâu, ta gọi dp[i][j] là độ dài xâu con chung dài nhất của Ai và Bj
 * 
 * B2: Liên hệ trạng thái bài toán:
 * dễ nhận thấy:
 * dp[0][j] = 0
 * dp[i][0] = 0
 * 
 * Khi xét đến kí tự thứ i và j, ta có 2 trường hợp sau:
 * Nếu A[i] = B[j] ==> dp[i][j] = dp[i - 1][j - 1] + 1
 * 
 * Nếu A[i] != B[j]:
 * Lúc này xâu con chung dài nhất của A[0..i] và B[0..j] sẽ không bao gồm 2 kí tự này, bởi vì 2 kí
 * tự này không giống nhau, và ta không thể thêm cả hai vào xâu con chung
 * ==> TH1: Nếu bỏ qua kí tự A[i] và xét A[0..i-1] và B[0..j] -> dp[i-1][j]
 * ta có thể tìm đc xâu con chung dài nhất giữa đầu của xâu A và xâu B mà không sử dụng
 * kí tự A[i]
 * 
 * ==> TH2: Nếu bỏ qua kí tự B[j] và xét A[0..i] và B[0..j-1] -> dp[i][j - 1]
 * ta có thể tìm được xâu con chung dài nhất giữa đầu của xâu A và xâu B mà không
 * sử dụng kí tự B[j]
 * 
 * ==> Công thức tổng quan:
 * dp[0][j] = 0;
 * dp[i][0] = 0;
 * dp[i][j] = dp[i - 1][j - 1] + 1              nếu A[i] = B[j];
 * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])   nếu A[i] != B[j];
 * 
 * B3: Xác định kết quả
 * Với xác định trạng thái bài toán ==> dp[m][n] là kết quả 
 * với m là độ dài của xâu A
 *     n là độ dài của xâu B
 * 
 * Time complexity:  O(m * n)
 * Space complexity: O(m * n)
 */
public class xau_con_chung_dai_nhat {
  public int solve(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++)
      dp[i][0] = 0;

    for (int j = 0; j <= n; j++)
      dp[0][j] = 0;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        }
        else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }
}

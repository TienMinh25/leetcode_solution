/**
 * Phân tích bài toán:
 * Tìm max k repeating của word in sequence (với word là subsequence của
 * sequence) -> tức là liền nhau
 * Ví dụ:
 * sequence = ababcab
 * word = ab
 * ==> kết quả: 2
 * 
 * Solution: using kĩ thuật dynamic programming
 * B1: Xác định trạng thái bài toán
 * Trạng thái bài toán là số lần lặp khi xét đến vị trí thứ i (index) trong
 * sequence
 * (Với 0 <= i <= sequence.length)
 * 
 * B2: Liên hệ trạng thái
 * VD:
 * sequence = ababc, word = ab
 * dp: 0 0 1 0 2
 * dp[0] = 0
 * dp[1] = 0
 * dp[2] = dp[2 - word.length] + 1 = dp[0] + 1 = 1
 * dp[3] = 0
 * dp[4] = dp[4 - word.length] + 1 = dp[2] + 1 = 2
 * Khi xét như này, ta thấy rằng:
 * dp[i] = dp[i - word.length] + 1;
 * 
 */
class Solution {
  public int maxRepeating(String sequence, String word) {
      // Solution 1: test every k value for word
      /*
      int k = 0;

      while (sequence.contains(newWord(word, k + 1))) {
          k++;
      }

      return k;
      */

      // Solution 2: sử dụng kỹ thuật dynamic programming
      int n = sequence.length();
      int m = word.length();
      int[] dp = new int[n + 1];
      int result = 0;

      for (int i = m; i < n; i++) {
        if (sequence.substring(i - m, i).equals(word)) {
          dp[i] = dp[i - m] + 1;
          result = Math.max(result, dp[i]);
        }
        else {
          dp[i] = 0;
        }
      }

      return result;
  }

  public String newWord(String word, int k) {
      StringBuilder newWorldBuilder = new StringBuilder();

      for (int i = 0; i < k; i++) {
          newWorldBuilder.append(word);
      }

      return newWorldBuilder.toString();
  }
}
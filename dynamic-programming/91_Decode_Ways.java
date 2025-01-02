/**
 * B1: Xác định trạng thái bài toán
 * Gọi xâu Si là xâu gồm các kí tự từ S[1..i]
 * Gọi dp[i] là số cách decode của xâu S[1..i]
 * 
 * dp[i] là trạng thái bài toán
 * 
 * B2: Liên hệ trạng thái:
 * 
 * Khi xét kí tự thứ i ta thấy:
 * Có 2 cách để decode:
 * ==> Công thức:
 * Ta có 2 TH có thể tạo, có thể là one kí tự, có thể là two kí tự
 * Nếu 1 <= one <= 9 => dp[i] += dp[i - 1]
 * Nếu 10 <= two <= 26 => dp[i] += dp[i - 2]
 * 
 * Tại sao lại có cách cộng như vậy, hãy nghĩ về 1 cái cây và cách decode đc xây
 * dựa trên cây này, thì mỗi một bước
 * chọn 1 kí tự hay 2 kí tự để decode thì sẽ vẽ ra 2 nhánh, như vậy mỗi nhánh là
 * 1 cách r ==> cộng thêm
 * 
 * space complexity: O(n)
 * time complexity: O(n)
 */
class Solution {
  public int numDecodings(String s) {
      int n = s.length();

      if (s.charAt(0) == '0') {
          return 0;
      }

      int[] dp = new int[n + 1];
      // Tại sao dp[0] = 1 --> ở đây cho case đầu tiên đó là khi i = 2, xét được 2 kí
      // tự thì + 1 cách
      dp[0] = dp[1] = 1;

      for (int i = 2; i <= n; i++) {
          int one = Integer.valueOf(s.substring(i - 1, i));
          int two = Integer.valueOf(s.substring(i - 2, i));

          if (1 <= one && one <= 9)
              dp[i] += dp[i - 1];

          if (10 <= two && two <= 26)
              dp[i] += dp[i - 2];
      }

      return dp[n];
  }
}
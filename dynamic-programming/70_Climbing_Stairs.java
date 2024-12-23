/**
 * - Solution: sử dụng kĩ thuật dynamic programming
 * B1: Tìm ra trạng thái bài toán
 * Gọi số bước có thể đi đến top là f(i), với i là bước thứ i (0 <= i <= n)
 * B2: Liên hệ giữa các trạng thái
 * Vì có 2 cách có thể nếu đi lên đến top, đó là bước 1 bước và bước 2 bước
 * ==>
 * f(i) = f(i-1) + f(i-2)
 * f(0) = 0 -> vì i = 0 thì ko cần bước
 * f(1) = 1 -> vì i = 1 thì chỉ có 1 cách bước
 */
class Solution {
  public int climbStairs(int n) {
      /*
      int[] dp = new int[46];

      dp[0] = 0;
      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 3;

      for (int i = 4; i <= n; i++)
          dp[i] = dp[i - 1] + dp[i - 2];

      return dp[n];
      */

      // optimize memory
      if (n <= 3) {
          return n;
      }

      int prevSecond = 2, prevOne = 3;
      int result = 0;

      for (int i = 4; i <= n; i++) {
          result = prevSecond + prevOne;
          prevSecond = prevOne;
          prevOne = result;
      } 

      return result;
  }
}
/**
 * Solution: sử dụng kĩ thuật dynamic programming
 * Phân tích bài toán: với mỗi vị trí bậc thang sẽ phải trả 1 giá tiền, và tại 1
 * ví trí này có thể bước 1 hoặc 2 bước để lên tới đỉnh
 * đỉnh ở đây thì chỉ cần >= cost.length là okela (vì lớn hơn hoặc bằng số bậc
 * thang hiện có)
 * 
 * B1: Xác định trạng thái bài toán
 * Trạng thái bài toán là chi phí nhỏ nhất để đi đến được bậc thang thứ i, với i
 * <= n (n = cost.length)
 * 
 * B2: Liên hệ giữa các trạng thái
 * Ta thấy: vì ở mỗi bậc thang có thể đi 1 hojwac 2 bậc thôi
 * ==> đối với 2 hướng đi 1 hoặc 2 ==> chi phí có thể khsac nhau vì mỗi bậc
 * thang nó sẽ khác nhau
 * ==> Gọi hàm f[i] là chi phí nhỏ nhất khi đi đến bậc thang thứ i
 * 
 * f[0] = 0;
 * f[1] = cost[0];
 * f[i] = min(f[i-1] + cost[i], f[i-2] + cost[i]);
 * 
 * Trạng thái bắt đầu thì có thể bắt đầu từ index 0 hoặc index 1
 * 
 * có edge case không? --> nếu chi phí đến bậc i-1 và i-2 giống nhau thì chọn
 * bậc nào?? chọn bậc nào chả được =))
 */
class Solution {
  public int minCostClimbingStairs(int[] cost) {
      int n = cost.length;

      int[] dp = new int[n + 1];
      dp[0] = cost[0];
      dp[1] = cost[1];

      for (int i = 2; i < n; i++) {
          dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
      }

      return Math.min(dp[n - 1], dp[n - 2]);
  }
}
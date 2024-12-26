/**
 * Phân tích bài toán:
 * Đứng ở vị trí có index 0, value nhảy là giá trị của phần tử tại đó
 * Trả về true nếu có thể nhảy đến cuối, trả về false nếu không thể nhảy đến
 * cuối
 * 
 * B1: Xác định trạng thái bài toán
 * Gọi dp[i] đại diện cho việc có thể nhảy đến index i được hay không
 * dp[i] là trạng thái bài toán (i < n)
 * 
 * B2: Liên hệ trạng thái bài toán
 * Ta thấy rằng, ở mỗi bước, ta chỉ có 1 lựa chọn, đó là nhảy lên k <= a[i] bước
 * 
 * dp[0] = true -> vì ta đã đứng đó từ đầu
 * 
 * Ta thấy rằng:
 Bước dp
 * 
 * B3: Xác định trạng thái bài toán
 * dp[n]
 * Vì mỗi bước index i, được xác định bằng các trạng thái trước đó ==> n chính
 * là index cuối xác định xem
 * việc nhảy đến được là đúng hay sai
 */
class Solution {
  public boolean canJump(int[] nums) {
      int[] dp = new int[nums.length];

      dp[0] = nums[0];

      for (int i = 1; i < nums.length; i++) {
          for (int k = 1; k <= dp[i - 1]; k++) {
              if (i - k >= 0) {
                  dp[i] = dp[i - k];
              }
          }
      }

      return false;
  }
}
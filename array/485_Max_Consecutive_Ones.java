/*
* Solution: duyệt qua mảng, có 1 biến global về tổng số 1 max (đồng thời đây là độ dài của mảng 1 liên tiếp dài nhất)
* và 1 biến curr_sum để check về current sum hiện tại của sub array chứa 1 liên tiếp
*/
class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
      int n = nums.length;
      int cur_length = 0, max_length = 0;

      for (int i = 0; i < n; i++) {
          if (nums[i] == 0) {
              max_length = Math.max(cur_length, max_length);
              cur_length = 0;
          }
          else cur_length++;
      }

      max_length = Math.max(cur_length, max_length);

      return max_length;
  }
}
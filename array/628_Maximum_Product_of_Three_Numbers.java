/**
 * - Solution 1: Sorting + nhận thấy là:
 * max lớn nhất có thể tạo chỉ có 2 trường hợp:
 * Có ít nhất 3 số dương ==> 3 số cuối sau khi sắp xếp nhân với nhau
 * Không có đủ 3 số dương ==> 1 số dương * 2 số âm bé nhất
 * time complexity: O(nlogn), space complexity: O(1)
 * 
 * - Solution 2: Nhớ đến bài toán third maximum ==> triển khải như vậy để tìm 3
 * max, 2 min =))
 * Thì cũng sau đó so sánh max
 * ==> time complexity: O(n), space complexity: O(1)
 */
class Solution {
  public int maximumProduct(int[] nums) {
      // Solution 1:
      /*
       * int n = nums.length;
       * 
       * Arrays.sort(nums);
       * 
       * return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] *
       * nums[n - 3]);
       */

      int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE,
              min2 = Integer.MAX_VALUE;

      for (int i = 0; i < nums.length; i++) {
          if (max1 < nums[i]) {
              max3 = max2;
              max2 = max1;
              max1 = nums[i];
          } else if (max1 >= nums[i] && max2 < nums[i]) {
              max3 = max2;
              max2 = nums[i];
          } else if (max2 >= nums[i] && max3 < nums[i]) {
              max3 = nums[i];
          }

          if (min1 > nums[i]) {
              min2 = min1;
              min1 = nums[i];
          } else if (min2 > nums[i] && nums[i] >= min1) {
              min2 = nums[i];
          }
      }

      return Math.max(max1 * max2 * max3, max1 * min1 * min2);
  }
}
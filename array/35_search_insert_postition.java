/*
Solution: Bản chất ở đây là xây dựng hàm lower bound giống bên c++ array.
*/
class Solution {
  public int searchInsert(int[] nums, int target) {
      int low = 0, high = nums.length;

      while (low < high) {
          int mid = (low + high) / 2;

          if (nums[mid] >= target) {
              high = mid;
          } else {
              low = mid + 1;
          }
      }

      while (low < nums.length && nums[low] < target) {
          low++;
      }

      return low;
  }
}
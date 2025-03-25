class Solution {
  public void nextPermutation(int[] nums) {
      int rightMostIdx = -1;
      int n = nums.length;

      for (int i = 0; i < n - 1; i++) {
          if (nums[i] < nums[i + 1]) {
              rightMostIdx = i;
          }
      }

      // case [3, 2, 1] -> [1, 2, 3]
      if (rightMostIdx == -1) {
          reverseArray(nums, 0, n - 1);
          return;
      }

      // case not [3, 2, 1]
      // find the right most greater than nums[rightMostIdx]
      for (int i = n - 1; i >= 0; i--) {
          if (nums[i] > nums[rightMostIdx]) {
              int tmp = nums[i];
              nums[i] = nums[rightMostIdx];
              nums[rightMostIdx] = tmp;
              break;
          }
      }

      reverseArray(nums, rightMostIdx + 1, n - 1);
  }

  private void reverseArray(int[] nums, int start, int end) {
      while (start < end) {
          int tmp = nums[start];
          nums[start] = nums[end];
          nums[end] = tmp;
          start++; end--;
      }
  }
}
class Solution {
  public void moveZeroes(int[] nums) {
      int n = nums.length;

      if (n == 1) {
          return;
      }

      int left = 0;

      while (left < n && nums[left] != 0) 
          left++;

      for (int right = 0; right < n; right++) {
          if (right > left && nums[right] != 0) {
              swap(nums, right, left);
              left++;
          }
      }
  }

  public void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
  }
}
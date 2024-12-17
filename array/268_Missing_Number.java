class Solution {
  public int missingNumber(int[] nums) {
      // Solution 1: using math =))
      int n = nums.length;

      int sumOfRange = (n * (n + 1)) / 2;
      int currSumOfInput = 0;

      for (int i = 0; i < n; i++) {
          currSumOfInput += nums[i];
      }

      return sumOfRange - currSumOfInput;
      
      // Solution 2: using sorting
      /*
      int n = nums.length;
      Arrays.sort(nums);

      for (int i = 0; i < n - 1; i++) {
          if (nums[i] + 1 != nums[i + 1]) {
              return nums[i] + 1;
          }
      }

      if (nums[0] == 0) {
          return nums[n - 1] + 1;
      }

      return 0;
      */
  }
}
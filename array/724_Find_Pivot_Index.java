class Solution {
  public int pivotIndex(int[] nums) {
      int n = nums.length;
      int[] prefixSum = new int[n + 1];

      for (int i = 1; i < prefixSum.length; i++) {
          prefixSum[i] = prefixSum[i-1] + nums[i-1];
      }

      for (int i = 0; i < n; i++) {
          int left = i == 0 ? 0 : prefixSum[i];
          int right = i == nums.length - 1 ? 0 : prefixSum[n] - prefixSum[i + 1];

          if (left == right)
              return i;
      }

      return -1;
  }
}

// 0 2 4 5 7 10
//   2 2 1 2 3
// 10 -5
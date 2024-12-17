/*
 * Solution: Using the prefix sum technique to solve this problem.
 * The problem involves calculating the sum of a subarray (a contiguous part of the array).
 * With the prefix sum, we can calculate the sum of any subarray in constant time after an initial preprocessing step.
 * 
 * The idea is to create a new array where each element at index `i` stores the sum of all elements from the beginning 
 * of the input array up to index `i`. Then, to compute the sum of any subarray, we can simply subtract the prefix sum 
 * at the start of the subarray from the prefix sum at the end of the subarray.
 */

 class NumArray {
  int[] prefixSum;

  // Constructor: Initialize the prefix sum array
  public NumArray(int[] nums) {
      this.prefixSum = nums; // Initialize prefixSum with the input array
      // Populate the prefixSum array with cumulative sums
      for (int i = 1; i < nums.length; i++) {
          prefixSum[i] += prefixSum[i-1]; // Update each element with the cumulative sum
      }
  }

  // Method to return the sum of elements between indices 'left' and 'right' (inclusive)
  public int sumRange(int left, int right) {
      // If left is 0, we return the prefix sum at index 'right' directly
      if (left == 0) 
          return prefixSum[right];

      // Otherwise, the sum of the range [left, right] is the difference between the prefix sum at 'right' 
      // and the prefix sum at 'left - 1'
      return prefixSum[right] - prefixSum[left - 1];
  }
}

/**
* Your NumArray object will be instantiated and called as follows:
* NumArray obj = new NumArray(nums);
* int param_1 = obj.sumRange(left,right);
*/
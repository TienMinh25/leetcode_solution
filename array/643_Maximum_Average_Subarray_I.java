/**
Solution: bài này sử dụng kĩ thuật sliding window, với window fixed size k
 */
class Solution {
  public double findMaxAverage(int[] nums, int k) {
      double result;
      int sumOfWindow = 0;

      for (int i = 0; i < k; i++) 
          sumOfWindow += nums[i];
      
      result = sumOfWindow / (double)k;

      for (int i = k; i < nums.length; i++) {
          sumOfWindow = sumOfWindow - nums[i - k] + nums[i];
          result = Math.max(result, sumOfWindow / (double)k);
      }

      return result;
  } 
}
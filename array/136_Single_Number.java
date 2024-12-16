/*
 * Solution: The XOR operation can be used to solve this problem efficiently.
 * The key idea is that XOR of two identical numbers results in 0 (i.e., a ^ a = 0).
 * Additionally, XOR of a number with 0 results in the number itself (i.e., a ^ 0 = a).
 * So, when we XOR all numbers in the array, the numbers that appear twice will cancel each other out 
 * (because a ^ a = 0), leaving only the number that appears once.
 * 
 * Example:
 * Given the array [4, 1, 2, 1, 2], XOR will cancel out the 1s and 2s, leaving 4 as the result.
 * Step-by-step XOR:
 * 4 ^ 1 ^ 2 ^ 1 ^ 2 = 4
 */
class Solution {
  public int singleNumber(int[] nums) {
      // Initialize result with the first number in the array
      int result = nums[0];

      // Loop through the rest of the numbers, applying XOR to find the single number
      for (int i = 1; i < nums.length; i++)
          result ^= nums[i]; // XOR the current number with result

      // Return the number that appears only once
      return result;
  }
}
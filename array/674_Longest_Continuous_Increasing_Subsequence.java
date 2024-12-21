/**
 * Solution: Keep the length of each increasing sequence in a variable and one
 * global variable for updating it with all the lengths of increasing sequences.
 */
class Solution {
  public int findLengthOfLCIS(int[] nums) {
      int currLength = 1;
      int result = 1;

      for (int i = 0; i < nums.length - 1; i++) {
          if (nums[i] < nums[i + 1]) {
              currLength++;
          } else {
              result = Math.max(currLength, result);
              currLength = 1;
          }
      }

      result = Math.max(currLength, result);

      return result;
  }
}
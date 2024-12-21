class Solution {
  public int[] findErrorNums(int[] nums) {
      // Solution 1: using sort and math to find
      /*
      int[] result = new int[2];

      Arrays.sort(nums);
      int idx = 0;
      int sumOfNums = 0;

      for (int i = 0; i < nums.length - 1; i++) {
          idx = i;
          sumOfNums += nums[i];
          if (nums[i] == nums[i + 1]) {
              result[0] = nums[i];
              break;
          }
      } 

      for (int i = idx + 1; i < nums.length; i++) {
          sumOfNums += nums[i];
      }
      
      result[1] = result[0] + nums.length * (1 + nums.length) / 2 - sumOfNums;

      return result;
      */

      // solution 2: index as hash key
      int[] count = new int[nums.length + 1];

      for (var num : nums)
          count[num]++;

      int dup = -1, loss = -1;

      for (int i = 1; i < count.length; i++)
          if (count[i] > 1)
              dup = i;
          else if (count[i] == 0)
              loss = i;
      
      return new int[]{dup, loss};
  }
}
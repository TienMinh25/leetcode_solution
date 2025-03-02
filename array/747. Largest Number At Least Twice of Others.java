// array -> easy
class Solution {
  public int dominantIndex(int[] nums) {
      int idx = 0; // int -> 4 bytes, 2 bytes

      for (int i = 1; i < nums.length; i++) {
          // compare 
          if (nums[i] > nums[idx]) {
              idx = i;
          }
      }
          

      for (int i = 0; i < nums.length; i++) {
          if (i == idx) {
              continue;
          }

          if (nums[i] * 2 > nums[idx]) {
              return -1;
          }
      } 

      return idx;
  }
}

// find largest number -> index
// at least twice 
// 1 * 2 = 2 < 3
// space complexity: O(1)
// time complexity: O(n)
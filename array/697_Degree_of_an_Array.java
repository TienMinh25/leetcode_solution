import java.util.HashMap;

class Solution {
  public int findShortestSubArray(int[] nums) {
      HashMap<Integer, Integer> count_num = new HashMap<>();

      int res = 0, degree = 0;

      HashMap<Integer, Integer> first_seen = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
          first_seen.putIfAbsent(nums[i], i);
          count_num.put(nums[i], count_num.getOrDefault(nums[i], 0) + 1);

          if (count_num.get(nums[i]) > degree) {
              degree = count_num.get(nums[i]);
              res = i - first_seen.get(nums[i]) + 1;
          } else if (count_num.get(nums[i]) == degree) {
              res = Math.min(res, i - first_seen.get(nums[i]) + 1);
          }
      }

      return res;
  }
}
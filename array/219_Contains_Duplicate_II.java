
import java.util.HashMap;
import java.util.Map;

/*
 * Solution to check if there are duplicate elements in the array such that
 * the difference between their indices is at most `k`.
 *
 * Solution 1: Use a HashMap to track the last index of each element.
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 * Solution 2: Use a sliding window with a HashSet to maintain elements within
 * a range of size `k`.
 * Time complexity: O(n)
 * Space complexity: O(k)
 */
class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // solution 1: using hash map
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numMap.containsKey(nums[i])) {
                numMap.put(nums[i], i);
            } else {
                if (k >= i - numMap.get(nums[i])) {
                    return true;
                } else {
                    numMap.put(nums[i], i);
                }
            }
        }

        return false;

        // solution 2: using sliding window technique
        // define: size k
        /*
      Set<Integer> numSet = new HashSet<>();

      for (int i = 0; i < nums.length; i++) {
          if (numSet.contains(nums[i])) {
              return true;
          }

          if (numSet.size() < k) {
              numSet.add(nums[i]);
          } 
          else {
              numSet.add(nums[i]);
              numSet.remove(nums[i - k]);
          }
      }

      return false;
         */
    }
}

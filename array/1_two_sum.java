
/**
 * Given an array of integers (nums) and a target integer,
 * return the indices of two numbers in the array that add up to the target.
 *
 * Approach:
 * 1. Solution 1: Brute force using nested loops.
 *    - Iterate through all pairs of numbers in the array to check if their sum equals the target.
 *    - Time complexity: O(n^2) (acceptable for small input sizes).
 *    - Space complexity: O(1).
 *
 * 2. Solution 2: Two-pointer approach after sorting the array.
 *    - Sort the array and use two pointers to find the target sum.
 *    - Time complexity: O(n log n) (sorting dominates).
 *    - Space complexity: O(1).
 *    - Note: Not suitable as sorting changes the indices of elements.
 *
 * 3. Solution 3: HashMap to store value-index pairs.
 *    - Use a HashMap to store each number as the key and its index as the value.
 *    - For each number, calculate the complement (target - current number) and check if it exists in the HashMap.
 *    - If it exists, return the indices.
 *    - Time complexity: O(n).
 *    - Space complexity: O(n).
 *    - Note: Overwriting indices in the HashMap is fine since the problem guarantees a valid solution.
 *
 * 4. Solution 4: Binary search after sorting.
 *    - Sort the array and use binary search to find the complement.
 *    - Time complexity: O(n log n) (due to sorting).
 *    - Space complexity: O(1).
 *    - Note: Not suitable as sorting changes the indices of elements.
 */
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        // Solution 1: Brute force (commented out)
        /*
         for (int i = 0; i < nums.length; i++) {
             for (int j = 0; j < nums.length; j++) {
                 if (nums[i] + nums[j] == target && i != j) {
                     return new int[]{i, j};
                 }
             }
         }
 
         return new int[]{};
         */

        // Solution 3: HashMap approach
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            int numberFind = target - nums[i]; // Calculate the complement

            // Check if the complement exists in the HashMap
            if (numMap.containsKey(numberFind)) {
                return new int[]{i, numMap.get(numberFind)}; // Return indices if found
            }

            // Add the current number and its index to the HashMap
            numMap.put(nums[i], i);
        }

        // Return an empty array if no solution is found (though problem guarantees a solution)
        return new int[]{};
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Contains Duplicate --------------------------- Given an integer
 * array `nums`, return `true` if any value appears at least twice in the array,
 * and `false` if every element is distinct.
 *
 * Example 1: Input: nums = [1,2,3,1] Output: true
 *
 * Example 2: Input: nums = [1,2,3,4] Output: false
 *
 * Example 3: Input: nums = [1,1,1,3,3,4,3,2,4,2] Output: true
 *
 * Constraints: - 1 <= nums.length <= 10^5 -10^9 <= nums[i] <= 10^9
 *
 * Solutions: 1. Using Sorting: - Sort the array and check for adjacent
 * duplicate elements. - Time Complexity: O(n log n), due to sorting. - Space
 * Complexity: O(1), if sorting is in-place.
 *
 * 2. Using HashMap: - Use a HashMap to count the occurrences of each element. -
 * Time Complexity: O(n), as we traverse the array and perform constant-time
 * operations. - Space Complexity: O(n), for storing the map.
 */
class Solution {

    public boolean containsDuplicate(int[] nums) {
        // Solution 1: Using sorting
        /*
        Arrays.sort(nums); // Sort the array in ascending order

        // Check for adjacent duplicate elements
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true; // Duplicate found
            }
        }

        return false; // No duplicates found
         */

        // Solution 2: Using HashMap
        // Create a HashMap to store the frequency of each number
        Map<Integer, Integer> numMap = new HashMap<>();

        // Traverse through the array and update the frequency in the map
        for (var x : nums) {
            numMap.put(x, numMap.getOrDefault(x, 0) + 1);
        }

        // Check if any number has a frequency greater than 1
        for (var key : numMap.keySet()) {
            if (numMap.get(key) > 1) {
                return true; // Duplicate found
            }
        }

        return false; // No duplicates found
    }
}

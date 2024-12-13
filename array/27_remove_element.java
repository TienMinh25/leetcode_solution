
/**
 * Removes all instances of a specific value (val) from the array and returns the new length.
 * The relative order of the remaining elements may be changed.
 *
 * Approach:
 * 1. Solution 1: Single loop with index tracking.
 *    - Use a variable `keepTrackIndex` to track the position for valid elements.
 *    - Traverse the array and skip elements equal to `val`.
 *    - For non-`val` elements, overwrite the current position at `keepTrackIndex` and increment it.
 *    - Time complexity: O(n).
 *    - Space complexity: O(1).
 *
 * 2. Solution 2: Using a HashMap (commented out).
 *    - Use a HashMap to store the indices and values of elements not equal to `val`.
 *    - Traverse the array, and for non-`val` elements, insert them into the HashMap and overwrite the array.
 *    - Time complexity: O(n).
 *    - Space complexity: O(2n).
 */
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int removeElement(int[] nums, int val) {
        // Solution 1: Single loop with index tracking
        int keepTrackIndex = 0; // Tracks the position for valid elements

        for (var x : nums) {
            if (x != val) { // Skip elements equal to `val`
                nums[keepTrackIndex] = x; // Place the valid element at `keepTrackIndex`
                keepTrackIndex++; // Increment the index
            }
        }

        return keepTrackIndex; // Return the count of valid elements

        // Solution 2: Using a HashMap (commented out)
        /*
         Map<Integer, Integer> numMap = new HashMap<>();
         int k = 0; // Tracks the number of valid elements
 
         for (var x : nums) {
             if (x != val) { // Skip elements equal to `val`
                 nums[k] = x; // Place the valid element at position `k`
                 k++;
                 numMap.put(k, x); // Add to the HashMap
             }
         }
 
         return numMap.size(); // Return the size of the HashMap
         */
    }
}

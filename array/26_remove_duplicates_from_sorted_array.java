
/**
 * Removes duplicates from a sorted array and returns the number of unique elements.
 *
 * Approach:
 * 1. Solution 1: Single loop with comparison.
 *    - Start with the first element as a reference.
 *    - Traverse the array and compare each element with the reference.
 *    - If a different value is found, replace the element at position `k` and increment `k`.
 *    - Time complexity: O(n).
 *    - Space complexity: O(1).
 *
 * 2. Solution 2: Using a HashSet.
 *    - Traverse the array and use a HashSet to track unique elements.
 *    - For each unique element, move it to the front of the array.
 *    - Time complexity: O(n) for iteration, but can be O(n^2) in worst case due to HashSet operations.
 *    - Space complexity: O(n) due to the HashSet.
 */
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int removeDuplicates(int[] nums) {
        // Solution 1: Single loop with comparison (commented out)
        /*
         int k = 1; // Tracks the position of the next unique element
         int elementCompare = nums[0]; // Reference value for comparison
         int n = nums.length;
 
         // Traverse the array starting from the second element
         for (int i = 1; i < n; i++) {
             if (nums[i] != elementCompare) { // If a new unique element is found
                 nums[k] = nums[i]; // Place it in the position `k`
                 elementCompare = nums[i]; // Update the reference value
                 k++; // Increment the unique element count
             }
         }
 
         return k; // Return the count of unique elements
         */

        // Solution 2: Using a HashSet
        Set<Integer> numSet = new HashSet<>(); // To track unique elements
        int index = 0; // Tracks the position of the next unique element

        // Traverse the array
        for (var x : nums) {
            if (numSet.contains(x)) { // If the element is not in the HashSet
                nums[index] = x; // Place it in the position `index`
                numSet.add(x); // Add the element to the HashSet
                index++; // Increment the unique element count
            }
        }

        return index; // Return the count of unique elements
    }
}

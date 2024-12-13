
/**
 * Implements a function to find the index where a target should be inserted in a sorted array.
 *
 * Approach:
 * - This method mimics the lower_bound function in C++.
 * - It uses binary search to find the first position where the target can be inserted to maintain the sorted order.
 *
 * Time Complexity: O(log n), as it performs a binary search.
 * Space Complexity: O(1), as it uses constant extra space.
 */
class Solution {

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;

        // Perform binary search to find the insertion point
        while (low < high) {
            int mid = (low + high) / 2;

            // If the middle element is greater than or equal to the target, adjust the high pointer
            if (nums[mid] >= target) {
                high = mid;
            } else {
                // Otherwise, adjust the low pointer
                low = mid + 1;
            }
        }

        // This ensures the pointer `low` represents the correct insertion index
        return low;
    }
}

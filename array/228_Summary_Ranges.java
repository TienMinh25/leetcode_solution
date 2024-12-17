/*
 * Solution:
 * 
 * - We use a pointer `j`, starting from index 1, and two variables `start` and `end` 
 *   to keep track of the start and end of the current subarray.
 * - Traverse the array using `j`. For each step:
 *   1. If `nums[j-1] != nums[j] - 1`, the current sorted subarray ends:
 *      - Add the subarray (from `start` to `end`) into the result list.
 *      - Update `start` to begin a new subarray starting at `nums[j]`.
 *   2. If `nums[j-1] == nums[j] - 1`, the subarray continues, so just increment `j`.
 * - After the loop, handle the last subarray and add it to the result.
 * 
 * The helper function `addSubSmallestSortedIntoResult` adds the subarray to the 
 * result list in the correct format:
 * - If the subarray contains a single element, it adds it as a single number.
 * - If the subarray contains multiple elements, it formats it as "start->end".
 */
class Solution {
  public List<String> summaryRanges(int[] nums) {
      List<String> result = new ArrayList<>();
      int n = nums.length;

      if (n == 0) {
          return result; // Return empty list if input is empty
      }

      int j = 1; // Pointer to traverse the array
      int start = nums[0], end = nums[0]; // Initialize start and end of the subarray

      while (j < n) {
          // Check if the current number is not consecutive
          if (nums[j - 1] != nums[j] - 1) {
              end = nums[j - 1]; // Set the end of the current subarray
              addSubSmallestSortedIntoResult(start, end, result); // Add subarray to result
              start = nums[j]; // Start a new subarray
          }
          j++; // Move to the next number
      }

      // Handle the last subarray
      end = nums[j - 1];
      addSubSmallestSortedIntoResult(start, end, result);

      return result;
  }

  // Helper function to add the subarray to the result list
  public void addSubSmallestSortedIntoResult(int start, int end, List<String> result) {
      if (start == end) {
          // If start == end, add as a single number
          result.add(String.valueOf(start));
      } else {
          // Otherwise, format as "start->end"
          result.add(start + "->" + end);
      }
  }
}

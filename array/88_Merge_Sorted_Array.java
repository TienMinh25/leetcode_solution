/**
 * Problem: Merge two sorted arrays, nums1 and nums2, into a single sorted array.
 * - nums1 has enough space to hold elements of both arrays.
 * - The first m elements of nums1 represent valid data.
 * - nums2 contains n elements.
 * 
 * Solution:
 * - Use two pointers, one for each array (nums1 and nums2), starting from the beginning.
 * - Compare the elements at the pointers:
 *   - If nums1's element is smaller or equal, add it to the result array and move the pointer in nums1.
 *   - Otherwise, add nums2's element to the result array and move the pointer in nums2.
 * - After comparing all elements in both arrays:
 *   - Copy any remaining elements from nums1 (if any) to the result array.
 *   - Copy any remaining elements from nums2 (if any) to the result array.
 * - Finally, copy the result array back into nums1.
 * 
 * Time Complexity: O(m + n), where m and n are the sizes of nums1 and nums2, respectively.
 * Space Complexity: O(m + n), as we use a separate array to store the merged result.
 */
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = 0, j = 0, k = 0; // Pointers for nums1, nums2, and result array
      int[] result = new int[m + n]; // Temporary array to hold merged result

      // Merge elements from both arrays in sorted order
      while (i < m && j < n) {
          if (nums1[i] <= nums2[j]) {
              result[k] = nums1[i];
              k++;
              i++;
          } else {
              result[k] = nums2[j];
              k++;
              j++;
          }
      }

      // Copy remaining elements from nums1 (if any)
      while (i < m) {
          result[k] = nums1[i];
          k++;
          i++;
      }

      // Copy remaining elements from nums2 (if any)
      while (j < n) {
          result[k] = nums2[j];
          k++;
          j++;
      }

      // Copy merged result back into nums1
      for (int x = 0; x < k; x++) {
          nums1[x] = result[x];
      }
  }
}

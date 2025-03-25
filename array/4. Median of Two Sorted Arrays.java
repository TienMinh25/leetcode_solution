class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      List<Integer> mergeArray = new ArrayList<>();
      int i = 0, j = 0;

      while (i < nums1.length && j < nums2.length) {
          if (nums1[i] <= nums2[j]) {
              mergeArray.add(nums1[i++]);
          } else {
              mergeArray.add(nums2[j++]);
          }
      }

      while (i < nums1.length) {
          mergeArray.add(nums1[i++]);
      }

      while (j < nums2.length) {
          mergeArray.add(nums2[j++]);
      }

      int n = mergeArray.size();

      if (n % 2 != 0) {
          return mergeArray.get(n >> 1);
      }

      return (mergeArray.get(n/2) + mergeArray.get(n/2 - 1)) / 2.0;
  }
}
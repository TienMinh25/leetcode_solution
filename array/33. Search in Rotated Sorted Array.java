class Solution {
  public int search(int[] nums, int target) {
      int pivot = -1;

      for (int i = 0; i < nums.length - 1; i++) {
          if (nums[i + 1] < nums[i]) {
              pivot = i;
          }
      }

      int leftSideIdx = searchIdxOfTarget(nums, 0, pivot, target);

      if (leftSideIdx != -1) {
          return leftSideIdx;
      }

      int rightSideIdx = searchIdxOfTarget(nums, pivot + 1, nums.length - 1, target);

      if (rightSideIdx != -1) {
          return rightSideIdx;
      }

      return -1;
  }

  private int searchIdxOfTarget(int[] nums, int start, int end, int target) {
      while (start <= end) {
          int mid = (start + end) >> 1;

          if (nums[mid] == target) {
              return mid;
          }

          if (nums[mid] > target) {
              end = mid - 1;
          } else {
              start = mid + 1;
          }
      }

      return -1;
  }
}
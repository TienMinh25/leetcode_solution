class Solution {
  public int maxArea(int[] height) {
      // use two pointer
      int left = 0, right = height.length - 1;
      int ans = 0;

      while (left < right) {
          int h = Math.min(height[left], height[right]);
          ans = Math.max(h * (right - left), ans);

          if (height[left] <= height[right]) {
              left++;
          } else {
              right--;
          }
      }

      return ans;
  }
}
// bai toan mong muon tim ra luong nuoc max co the chua
// co 2 yeu to -> 1 la chieu cao cang cao cang tot, 2 la chieu dai cang dai cang tot
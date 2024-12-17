/*
* Solution 1: sử dụng TreeSet
* time complexity: O(nlogn), space complexity: O(n)
* Solution 2: Sử dụng sort và 3 biến keep track
* time complexity: O(nlogn), space complexity: O(1) 
*
* Solution 3: sử dụng 3 biến để lưu trữ lại 3 giá trị max và 1 biến lưu lại giá trị distinct
* time complexity: O(n), space complexity: O(1)
*/
class Solution {
  public int thirdMax(int[] nums) {
      // Solution 1:
      /*
      TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

      for (var x : nums) {
          treeSet.add(x);
      }

      if (treeSet.size() < 3) {
          return treeSet.first();
      }

      treeSet.pollFirst();
      treeSet.pollFirst();

      return treeSet.first();
      */

      // Solution 3:
      long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
      int distinctCount = 0;
      for (var num : nums) {
          if (num > max1) {
              max3 = max2;
              max2 = max1;
              max1 = num;
              distinctCount++;
          } else if (num > max2 && num < max1) {
              max3 = max2;
              max2 = num;
              distinctCount++;
          } else if (num > max3 && num < max2) {
              max3 = num;
              distinctCount++;
          }
      }

      if (distinctCount < 3) {
          return (int)max1;
      }

      return (int)max3;
  }
}
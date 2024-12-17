/*
* Solution 1: using idea of counting sort
* time complexity: O(n), space complexity: O(n)
*/
class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
      // Solution 1: using idea of couting sort
      List<Integer> result = new ArrayList<>();
      int n = nums.length;
      int[] counting = new int[n + 1];

      for (var num : nums) {
          counting[num]++;
      }

      for (int i = 1; i <= n; i++) {
          if (counting[i] == 0) {
              result.add(i);
          }
      }

      return result;
  }
}
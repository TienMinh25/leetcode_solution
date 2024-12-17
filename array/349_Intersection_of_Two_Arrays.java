/*
* Solution 1: sử dụng hash map để xử lý bài toán
* Solution 2: sư dụng array
nói tóm gọn lại thì hầu hết đều đên từ ý tưởng của counting sort
*/
class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
      // solution 1:
      /*
      Map<Integer, Integer> numMap = new HashMap<>();

      for (var x : nums1) {
          if (!numMap.containsKey(x)) {
              numMap.put(x, 1);
          }
      }

      for (var x : nums2) {
          if (numMap.containsKey(x)) {
              numMap.put(x, numMap.get(x) + 1);
          }
      }

      int k = 0;

      for (Integer key : numMap.keySet()) {
          if (numMap.get(key) > 1)
              k++;
      }

      int[] result = new int[k];
      k = 0;

      for (Integer key : numMap.keySet()) {
          if (numMap.get(key) > 1) {
              result[k] = key;
              k++;
          }
      }
  
      return result;
      */

      // solution 2:
      int n = 1000;
      int[] tmp = new int[n+1];

      for (var x : nums1) 
          tmp[x] = 1;

      int[] ret = new int[n+1];
      int id = 0;

      for (var x : nums2) {
          if (tmp[x] == 1) {
              ret[id++] = x;
              tmp[x] = 0; 
          }
      }

      return Arrays.copyOf(ret, id);
  }
}
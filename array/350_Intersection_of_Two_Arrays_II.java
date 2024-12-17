class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      List<Integer> ret = new ArrayList<>();

      int i = 0, j = 0;

      while (i < nums1.length && j < nums2.length) {
          if (nums1[i] == nums2[j]) {
              ret.add(nums1[i]);
              i++;
              j++;
          }
          else if (nums1[i] > nums2[j]){
              j++;
          }
          else {
              i++;
          }
      }

      int[] result = new int[ret.size()];

      for (int k = 0; k < ret.size(); k++) 
          result[k] = ret.get(k);

      return result;
  }
}
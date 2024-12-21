class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
      Map<String, Integer> list2Map = new HashMap<>();

      for (int i = 0; i < list2.length; i++) {
          list2Map.put(list2[i], i);
      }

      int minIndexSum = Integer.MAX_VALUE;

      for (int i = 0; i < list1.length; i++) {
          if (list2Map.containsKey(list1[i])) {
              minIndexSum = Math.min(minIndexSum, i + list2Map.get(list1[i]));
          }
      }

      String[] tmp = new String[list1.length];
      int idx = 0;

      for (int i = 0; i < list1.length; i++) {
          if (list2Map.containsKey(list1[i]) && i + list2Map.get(list1[i]) == minIndexSum) {
              tmp[idx++] = list1[i];
          }
      }

      return Arrays.copyOfRange(tmp, 0, idx);
  }
}
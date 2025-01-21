/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  Integer mostFrequent = 0;

  public int[] findFrequentTreeSum(TreeNode root) {

      Map<Integer, Integer> treeMap = new HashMap<Integer, Integer>();

      postorder(root, treeMap);
      int[] rs = new int[treeMap.size()];
      int i = 0;

      for (var key : treeMap.keySet()) {
          if (treeMap.get(key) == mostFrequent) {
              rs[i++] = key;
          }
      }

      return Arrays.copyOf(rs, i);
  }

  private int postorder(TreeNode node, Map<Integer, Integer> treeMap) {
      if (node != null) {
          int left = postorder(node.left, treeMap);
          int right = postorder(node.right, treeMap);

          int key = right + left + node.val;
          mostFrequent = Math.max(mostFrequent, treeMap.getOrDefault(key, 0) + 1);
          treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);
          return key;
      }

      return 0;
  }
}
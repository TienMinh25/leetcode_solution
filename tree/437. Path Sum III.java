/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  private int count;

  public int pathSum(TreeNode root, int targetSum) {
      count = 0;
      Map<Long, Long> mapping = new HashMap<>();  

      traversalTree(root, 0, targetSum, mapping);

      return count;  
  }

  private void traversalTree(TreeNode node, long currSum, int targetSum, Map<Long, Long> mapping) {
      if (node == null) return;

      currSum += node.val;

      if (currSum == targetSum)
          count++;
      
      if (mapping.containsKey(currSum - targetSum)) {
          count += mapping.get(currSum - targetSum);
      }

      mapping.put(currSum, mapping.getOrDefault(currSum, 0L) + 1);

      traversalTree(node.left, currSum, targetSum, mapping);
      traversalTree(node.right, currSum, targetSum, mapping);

      mapping.put(currSum, mapping.get(currSum) - 1);
  }
}
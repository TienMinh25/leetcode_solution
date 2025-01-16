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
  // using dfs + variable to keep track level and most left node
  private int mostLeft;
  private int mostLevel = -1;

  public int findBottomLeftValue(TreeNode root) {
      preorder(root, 0);

      return mostLeft;
  }

  private void preorder(TreeNode node, int currLevel) {
      if (node != null) {
          if (mostLevel < currLevel) {
              mostLevel = currLevel;
              mostLeft = node.val;
          }
          preorder(node.left, currLevel + 1);
          preorder(node.right, currLevel + 1);
      }
  }
}
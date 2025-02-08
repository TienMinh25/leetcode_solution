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
// using inorder traversal
/**
 * 3
 * 0. 0
 * 2. 0 2 0
 * 6
 */
class Solution {
  private int moves;
  public int distributeCoins(TreeNode root) {
      moves = 0;
      
      coins_move(root);

      return moves;
  }

  private int coins_move(TreeNode node) {
      if (node == null)
          return 0;
      
      int left = coins_move(node.left);
      int right = coins_move(node.right);
      moves += Math.abs(left) + Math.abs(right);

      return node.val - 1 + left + right;
  }
}
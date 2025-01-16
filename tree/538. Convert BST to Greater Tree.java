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
// right -> root -> left
// using reverse inorder
class Solution {
  private int prev = 0;
  public TreeNode convertBST(TreeNode root) {
      reverseInorder(root);

      return root;
  }

  private void reverseInorder(TreeNode node) {
      if (node != null) {
          reverseInorder(node.right);
         
          node.val += prev;
          prev = node.val;

          reverseInorder(node.left);
      }
  }
}
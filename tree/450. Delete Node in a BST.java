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
  public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) {
          return null;
      }

      if (root.val > key) {
          root.left = deleteNode(root.left, key);
      } else if (root.val < key) {
          root.right = deleteNode(root.right, key);
      } else {
          var pre = predecessor(root.left);
          var succ = successor(root.right);

          if (pre != null) {
              root.val = pre.val;
              root.left = deleteNode(root.left, pre.val);
          } else if (succ != null) {
              root.val = succ.val;
              root.right = deleteNode(root.right, succ.val);
          } else {
              // case leaf node
              root = null;
          }
      }

      return root;
  }

  private TreeNode predecessor(TreeNode curr) {
      while (curr != null && curr.right != null) {
          curr = curr.right;
      }

      return curr;
  }

  private TreeNode successor(TreeNode curr) {
      while (curr != null && curr.left != null) {
          curr = curr.left;
      }

      return curr;
  }
}
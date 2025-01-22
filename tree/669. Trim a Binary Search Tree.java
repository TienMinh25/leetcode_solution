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
 // phai dung preorder traversal de lam bai nay
 // de y rang day la binary search tree
 // ==> ưng dung tinh chat cua BST ta thấy:
 // nếu root.val < low ==> bỏ cả subtree bên trái của tree và chính root
 // nếu root.val > high ==> bỏ cả subtree bên phải của tree và chính root
 class Solution {
  public TreeNode trimBST(TreeNode root, int low, int high) {
      if (root == null) {
          return null;
      }

      // lay mot minh right side cua root (vi left side chac chan be hon low)
      if (root.val < low) { 
          return trimBST(root.right, low, high);
      }

      // lay mot minh left side cua root (vi right side chac chan be hon low)
      if (root.val > high) {
          return trimBST(root.left, low, high);
      }

      root.left = trimBST(root.left, low, high);
      root.right = trimBST(root.right, low, high);

      return root;
  }
}
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

 // luon xem do la root de xu ly, sau do xu ly cho case left va right thi de dang nhat
 class Solution {
  public String tree2str(TreeNode root) {
      StringBuilder sb = new StringBuilder();

      dfs(root, sb);

      return sb.toString();
  }

  private void dfs(TreeNode t, StringBuilder sb) {
      if (t == null)
          return;

      sb.append(t.val);

      if (t.left == null && t.right == null)
          return;

      sb.append("(");
      dfs(t.left, sb);
      sb.append(")");
      
      if (t.right != null) {
          sb.append("(");
          dfs(t.right, sb);
          sb.append(")");
      }
  }
}
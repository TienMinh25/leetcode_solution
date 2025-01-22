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
// coi moi 1 node la 1 diem noi giua 2 duong dan ben trai va ben phai
// chi can tinh left va right ==> path = left + right (do tinh edge cua cac
// node)
class Solution {
  private int longestPath;

  public int longestUnivaluePath(TreeNode root) {
      if (root == null) {
          return 0;
      }

      longestPath = 0;
      postorder(root, root.val);

      return longestPath;
  }

  private int postorder(TreeNode node, int val) {
      if (node == null)
          return 0;

      int left = postorder(node.left, node.val);
      int right = postorder(node.right, node.val);

      // boi vi left va right tra ve da la valid ve path roi (tuc o buoc tinh toan, da
      // tinh toan luon cho path den nut goc do, nut dang dung hien tai)
      longestPath = Math.max(longestPath, left + right);

      if (node.val == val) {
          return 1 + Math.max(left, right);
      }

      return 0;
  }
}
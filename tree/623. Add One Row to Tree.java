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
  private int depth;
  private List<TreeNode> list;

  // su dung dfs de traversal ca left va right -> tinh tu dau den
  // dung bfs cung oke
  public TreeNode addOneRow(TreeNode root, int val, int depth) {
      // edge case
      if (depth == 1) {
          TreeNode newRoot = new TreeNode(val);
          newRoot.left = root;
          return newRoot;
      }

      this.depth = depth;
      list = new ArrayList<>();

      dfs(root, 1);

      list.forEach(node -> {
          addNode(node, val);
      });

      return root;
  }

  private void addNode(TreeNode node, int val) {
      TreeNode addLeft = new TreeNode(val);
      TreeNode addRight = new TreeNode(val);
      addLeft.left = node.left;
      addRight.right = node.right;
      node.left = addLeft;
      node.right = addRight;
  }

  private void dfs(TreeNode node, int currDepth) {
      if (node != null) {
          if (currDepth == this.depth - 1) {
              list.add(node);
          }
          dfs(node.left, currDepth + 1);
          dfs(node.right, currDepth + 1);
      }
  }
}
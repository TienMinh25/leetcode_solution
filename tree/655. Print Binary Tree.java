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
  private int m = -1, n;
  // duyet preorder
  public List<List<String>> printTree(TreeNode root) {
      int row = getHeight(root);
      int col = (1 << row) - 1;
      List<List<String>> rs = new ArrayList<>();

      for (int i = 0; i < row; i++) {
          var tempRow = new ArrayList<String>();
          for (int j = 0; j < col; j++) {
              tempRow.add("");
          }

          rs.add(tempRow);
      }

      populateArray(root, 0, 0, col - 1, rs);

      return rs;
  }

  private void populateArray(TreeNode node, int r, int startCol, int endCol, List<List<String>> rs) {
      if (node == null)
          return;

      int mid = (startCol + endCol) / 2;
      rs.get(r).set(mid, String.valueOf(node.val));
      populateArray(node.left, r + 1, startCol, mid - 1, rs);
      populateArray(node.right, r + 1, mid + 1, endCol, rs);
  }



  private int getHeight(TreeNode node) {
      if (node == null)
          return 0;
      
      return 1 + Math.max(getHeight(node.left), getHeight(node.right));
  }
}
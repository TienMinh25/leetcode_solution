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
  private int currIdx;

  public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
      List<Integer> rs = new ArrayList<>();
      currIdx = 0;
      boolean isFlipMatch = dfs(root, voyage, rs);

      if (isFlipMatch == false) {
          return List.of(-1);
      }

      return rs;
  }

  private boolean dfs(TreeNode node, int[] voyage, List<Integer> rs) {
      if (node == null) {
          return true;
      }

      if (node.val != voyage[currIdx++]) {
          return false;
      }

      // minh ko can thiet thuc su phai doi node cua cay, chi don gian
      // doi thu tu truyen trong func la oke roi
      if (node.left != null && node.left.val != voyage[currIdx]) {
          rs.add(node.val);
          return dfs(node.right, voyage, rs) && dfs(node.left, voyage, rs);
      }

      return dfs(node.left, voyage, rs) && dfs(node.right, voyage, rs);
  }
}
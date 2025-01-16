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
 // using bfs
 class Solution {
  public List<Integer> largestValues(TreeNode root) {
      List<Integer> rs = new ArrayList<>();

      if (root == null) {
          return rs;
      }

      Queue<TreeNode> treeQueue = new LinkedList<>(List.of(root));

      while (!treeQueue.isEmpty()) {
          var sizeLevel = treeQueue.size();
          Integer maxRow = Integer.MIN_VALUE;

          for (int i = 0; i < sizeLevel; i++) {
              var node = treeQueue.poll();

              maxRow = Math.max(node.val, maxRow);

              if (node.left != null) treeQueue.offer(node.left);
              if (node.right != null) treeQueue.offer(node.right);
          }

          rs.add(maxRow);
      }

      return rs;
  }
}
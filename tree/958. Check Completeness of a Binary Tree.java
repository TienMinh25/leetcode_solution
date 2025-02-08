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
  public boolean isCompleteTree(TreeNode root) {
      Queue<TreeNode> queueTree = new LinkedList<>(List.of(root));
      
      int level = 0;

      while (!queueTree.isEmpty()) {
          int sizeQueue = queueTree.size();
          boolean isLast = sizeQueue != (1 << level);
          boolean seenNull = false;

          for (int i = 0; i < sizeQueue; i++) {
              var node = queueTree.poll();

              if (node.left == null) {
                  seenNull = true;
              } else {
                  if (isLast || seenNull)
                      return false;
                  queueTree.offer(node.left);
              }

              if (node.right == null) {
                  seenNull = true;
              } else {
                  if (isLast || seenNull)
                      return false;
                  queueTree.offer(node.right);
              }
          }

          level++;
      }

      return true;
  }
}
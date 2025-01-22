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

// y tuong, hay nho den viec bieu dien complete binary tree duoc bieu dien duoi
// dang array
// tu do ta luu tru them index cua element, thi ta co the tinh ra duoc
class Solution {
  class Pair {
      TreeNode node;
      int idx;

      public Pair(TreeNode node, int idx) {
          this.node = node;
          this.idx = idx;
      }
  }

  public int widthOfBinaryTree(TreeNode root) {
      int maxWidth = 1;

      Queue<Pair> queue = new LinkedList<>();
      queue.offer(new Pair(root, 0));

      while (!queue.isEmpty()) {
          var levelSize = queue.size();
          int first = -1, last = -1;

          for (int i = 0; i < levelSize; i++) {
              var curr = queue.poll();

              if (i == 0)
                  first = curr.idx;
              if (i == levelSize - 1)
                  last = curr.idx;

              if (curr.node.left != null)
                  queue.offer(new Pair(curr.node.left, curr.idx * 2 + 1));

              if (curr.node.right != null)
                  queue.offer(new Pair(curr.node.right, curr.idx * 2 + 2));
          }

          maxWidth = Math.max(last - first + 1, maxWidth);
      }

      return maxWidth;
  }
}
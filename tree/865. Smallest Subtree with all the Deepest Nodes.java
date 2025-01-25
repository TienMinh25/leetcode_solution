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
/**
Write a sub function deep(TreeNode root).
Return a pair(int depth, TreeNode subtreeWithAllDeepest)

In sub function deep(TreeNode root):

if root == null,
return pair(0, null)

if left depth == right depth,
deepest nodes both in the left and right subtree,
return pair (left.depth + 1, root)

if left depth > right depth,
deepest nodes only in the left subtree,
return pair (left.depth + 1, left subtree)

if left depth < right depth,
deepest nodes only in the right subtree,
return pair (right.depth + 1, right subtree)
 */
class Solution {
  class Pair {
      Integer depth;
      TreeNode root;

      Pair(Integer depth, TreeNode root) {
          this.depth = depth;
          this.root = root;
      }
  }

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
      return deep(root).root;
  }

  private Pair deep(TreeNode node) {
      if (node == null)
          return new Pair(0, null);
      
      Pair left = deep(node.left), right = deep(node.right);
      int depth = Math.max(left.depth, right.depth) + 1;

      return new Pair(depth, left.depth == right.depth ? node : left.depth > right.depth ? left.root : right.root);
  }
}
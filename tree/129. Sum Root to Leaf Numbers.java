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
 // using depth first search (using preorder)
 // next value = 10 * a + node next
 // backtrack -> currValue / 10
class Solution {
    private int rs = 0;

    public int sumNumbers(TreeNode root) {
        preorder(root, 0);

        return rs;
    }

    private void preorder(TreeNode root, int prev) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                rs += (prev * 10 + root.val);
            } else {
                prev = prev * 10 + root.val;
                preorder(root.left, prev);
                preorder(root.right, prev);
            }
        }
    }
}
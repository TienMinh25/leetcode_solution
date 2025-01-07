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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // vừa check balance vừa tính chiều cao
    private int height(TreeNode t) {
        // base case 1
        if (t == null) {
            return 0;
        }

        int left = height(t.left);
        if (left == -1) return -1;

        int right = height(t.right);
        if (right == -1) return -1;

        // base case 2
        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
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
    int rs = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        
        return rs;
    }

    private void traversal(TreeNode tmp) {
        if (tmp != null) {
            traversal(tmp.left);
            
            if (prev != null) {
                rs = Math.min(rs, Math.abs(tmp.val - prev.val));
            }
            prev = tmp;
            traversal(tmp.right);
        }
    }
}
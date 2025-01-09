
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

    public int minDiffInBST(TreeNode root) {
        inorder(root);

        return rs;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);

            if (prev != null) {
                rs = Math.min(rs, Math.abs(root.val - prev.val));
            }

            prev = root;
            inorder(root.right);
        }
    }
}

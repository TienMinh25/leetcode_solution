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
 // Coi mỗi node là node gốc, thì luôn giữ cho left subtree và right subtree dài nhất có thể
 // vì mỗi node là node gốc nên mỗi node đều có tiềm năng là trong path dài nhất
 // ==> có 1 biến cập nhật
class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);
        res = Math.max(res, l + r);

        return Math.max(l, r) + 1;
    }
}
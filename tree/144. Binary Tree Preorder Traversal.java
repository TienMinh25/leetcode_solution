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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();

        preorder(root, rs);

        return rs;
    }

    private void preorder(TreeNode t, List<Integer> rs) {
        if (t != null) {
            rs.add(t.val);
            preorder(t.left, rs);
            preorder(t.right, rs);
        }
    }
}
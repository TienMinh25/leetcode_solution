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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();

        postorder(root, rs);

        return rs;
    }

    private void postorder(TreeNode t, List<Integer> rs) {
        if (t != null) {
            postorder(t.left, rs);
            postorder(t.right, rs);
            rs.add(t.val);
        }
    }
}
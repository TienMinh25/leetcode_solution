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
    public boolean evaluateTree(TreeNode root) {
        int rs = postorder(root);

        return rs == 1;
    }

    private int postorder(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null)
                return root.val;

            int left = postorder(root.left);
            int right = postorder(root.right);

            if (root.val == 2)
                return left | right;
            
            if (root.val == 3)
                return left & right;
        }

        // nothing to do right here, just by pass return for outside if (never occur) =))
        return 0;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode rs = null;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        inorder(cloned, target.val);
        return rs;
    }

    public void inorder(TreeNode cloned, int target) {
        if (cloned != null) {
            inorder(cloned.left, target);

            if (cloned.val == target) {
                rs = cloned;
                return;
            }

            inorder(cloned.right, target);
        }
    }
}
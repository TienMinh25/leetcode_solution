
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

    public boolean isUnivalTree(TreeNode root) {
        int rootValue = root.val;
        Stack<TreeNode> stackTree = new Stack<>();

        while (!stackTree.isEmpty() || root != null) {
            if (root != null) {
                stackTree.push(root);
                root = root.left;
            } else {
                var n1 = stackTree.pop();

                if (n1.val != rootValue) {
                    return false;
                }

                root = n1.right;
            }
        }

        return true;
    }
}

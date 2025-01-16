/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// sử dụng dfs để xử lý bài này được thôi
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pathP = new Stack<>();
        Stack<TreeNode> pathQ = new Stack<>();

        TreeNode curr1 = root, curr2 = root, rs = null;
        dfs(root, pathP, p);
        dfs(root, pathQ, q);

        while (!pathP.empty() && !pathQ.empty()) {
            var node1 = pathP.pop();
            var node2 = pathQ.pop();
            if (node1 == node2) {
                rs = node1;
            }
        }

        return rs;
    }

    private boolean dfs(TreeNode root, Stack<TreeNode> temp, TreeNode tempNode) {
        if (root != null) {
            if (root == tempNode) {
                temp.push(root);
                return true;
            }

            var leftSide = dfs(root.left, temp, tempNode);
            if (leftSide) {
                temp.push(root);
                return leftSide;
            }

            var rightSide = dfs(root.right, temp, tempNode);
            if (rightSide) {
                temp.push(root);
                return rightSide;
            }
        }

        return false;
    }
}
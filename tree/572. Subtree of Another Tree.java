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
 // Solution cho bài toán này đó là: chúng ta sẽ kiểm tra xem csac subtree có bằng subtree cho test hay không
 // với việc này thì coi như cây ban đầu cũng là 1 subtree
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isEqualTree(root, subRoot))
            return true;
        
        if (root == null)
            return false;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqualTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        
        return root1.val == root2.val && isEqualTree(root1.left, root2.left) && isEqualTree(root1.right, root2.right);
    }
}
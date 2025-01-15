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
    public boolean isValidBST(TreeNode root) {
        /*
        List<Integer> a = new ArrayList<>();

        inorder(root, a);

        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i) >= a.get(i + 1))
                return false;
        }

        return true;
        */
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (!(root.val > min && root.val < max))
            return false;

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }

    private void inorder(TreeNode root, List<Integer> a) {
        if (root != null) {
            inorder(root.left, a);
            a.add(root.val);
            inorder(root.right, a);
        }
    }
}
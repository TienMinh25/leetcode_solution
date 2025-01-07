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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rs = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        preorder(root, rs, sb);

        return rs;
    }

    private void preorder(TreeNode tmp, List<String> rs, StringBuilder sb) {
        if (tmp == null) {
            return;
        }

        int l = sb.length();
        sb.append(tmp.val);

        if (tmp.left == null && tmp.right == null) {
            rs.add(sb.toString());
        } else {
            sb.append("->");

            preorder(tmp.left, rs, sb);
            preorder(tmp.right, rs, sb);
        }

        sb.setLength(l);
    }
}

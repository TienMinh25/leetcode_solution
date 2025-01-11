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
    public int sumRootToLeaf(TreeNode root) {
        // solution 1: dfs + parse binary path
        /*
         * List<String> binaryPaths = new ArrayList<>();
         * StringBuilder sb = new StringBuilder();
         * 
         * dfs(root, binaryPaths, sb);
         * int rs = 0;
         * 
         * for (var binaryPath : binaryPaths) {
         * rs += Integer.parseInt(binaryPath, 2);
         * }
         * 
         * return rs;
         */
        return sumRootToLeaf(root, 0);
    }

    private int sumRootToLeaf(TreeNode node, int preSum) {
        if (node.left == null && node.right == null) {
            // or using bit
            // return preSum << 1 | node.val;
            return preSum * 2 + node.val;
        }

        int ans = 0;
        if (node.left != null) {
            // return sumRootToLeaf(node.left, preSum << 1 | node.val);
            ans += sumRootToLeaf(node.left, preSum * 2 + node.val);
        }

        if (node.right != null) {
            // return sumRootToLeaf(node.right, preSum << 1 | node.val);
            ans += sumRootToLeaf(node.right, preSum * 2 + node.val);
        }

        return ans;
    };

    private void dfs(TreeNode tmp, List<String> binaryPaths, StringBuilder sb) {
        if (tmp != null) {
            sb.append(tmp.val);

            if (tmp.left == null && tmp.right == null) {
                binaryPaths.add(sb.toString());
                sb.setLength(sb.length() - 1);
                return;
            }

            dfs(tmp.left, binaryPaths, sb);
            dfs(tmp.right, binaryPaths, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
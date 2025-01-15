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
    private List<List<Integer>> rs;

    // sử dụng depth first search (using preorder)
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        rs = new ArrayList<List<Integer>>();

        if (root == null) {
            return rs;
        }

        List<Integer> temp = new ArrayList<>();

        dfs(temp, root, targetSum, 0);

        return rs;
    }

    private void dfs(List<Integer> temp, TreeNode root, int targetSum, int currSum) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                currSum += root.val;
                temp.add(root.val);

                if (currSum == targetSum) {
                    rs.add(new ArrayList<>(temp));
                }

                temp.remove(temp.size() - 1);
            } else {
                currSum += root.val;
                temp.add(root.val);

                dfs(temp, root.left, targetSum, currSum);
                dfs(temp, root.right, targetSum, currSum);

                temp.remove(temp.size() - 1);
            }
        }
    }
}
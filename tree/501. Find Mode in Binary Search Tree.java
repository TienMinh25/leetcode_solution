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
    public int[] findMode(TreeNode root) {
        int maxMode = Integer.MIN_VALUE;
        HashMap<Integer, Integer> modeHash = new HashMap<>();
        Stack<TreeNode> stackNode = new Stack<>();

        while (root != null || !stackNode.isEmpty()) {
            if (root != null) {
                stackNode.push(root);
                maxMode = Math.max(maxMode, modeHash.getOrDefault(root.val, 0) + 1);
                modeHash.put(root.val, modeHash.getOrDefault(root.val, 0) + 1);
                root = root.left;
            } else {
                root = stackNode.pop();
                root = root.right;
            }
        }

        int[] tmp = new int[modeHash.size()];
        int currIndex = 0;

        for (var key : modeHash.keySet()) {
            if (modeHash.get(key) == maxMode)
                tmp[currIndex++] = key;
        }

        return Arrays.copyOf(tmp, currIndex);
    }
}
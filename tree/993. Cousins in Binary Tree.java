
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

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> treeQueue = new LinkedList<>(List.of(root));

        while (!treeQueue.isEmpty()) {
            int qLen = treeQueue.size();
            boolean isX = false, isY = false;

            for (int i = 0; i < qLen; i++) {
                var node = treeQueue.poll();

                if (node.val == x) {
                    isX = true;
                }

                if (node.val == y) {
                    isY = true;
                }

                // check two node left and right is sibling? if yes, it is not cousin
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }

                if (node.left != null) {
                    treeQueue.offer(node.left);
                }

                if (node.right != null) {
                    treeQueue.offer(node.right);
                }
            }

            if (isX && isY) {
                return true;
            }
        }

        return false;
    }
}

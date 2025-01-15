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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();

        if (root == null) {
            return rs;
        }
        
        Queue<TreeNode> queueTree = new LinkedList<>(List.of(root));

        while (!queueTree.isEmpty()) {
            int levelSize = queueTree.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                var node = queueTree.poll();

                if (node.left != null)
                    queueTree.offer(node.left);

                if (node.right != null)
                    queueTree.offer(node.right);

                temp.add(node.val);
            }

            rs.add(temp);
        }

        return rs;
    }
}
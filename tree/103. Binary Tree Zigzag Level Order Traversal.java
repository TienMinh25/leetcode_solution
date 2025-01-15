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
// 1 -> trai sang phai
// 2 -> phai sang trai
// 3 -> trai sang phai
// 4 -> phai sang trai
// lẻ là trái sang phải, chẵn là phải sang trái
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        Queue<TreeNode> queueTree = new LinkedList<>(List.of(root));
        int level = 1;

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

            if (level % 2 == 1) {
                rs.add(temp);
            } else {
                Collections.reverse(temp);
                rs.add(temp);
            }
            level++;
        }

        return rs;
    }
}
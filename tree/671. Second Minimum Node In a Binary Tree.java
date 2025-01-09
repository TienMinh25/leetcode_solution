
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
/**
 * Solution 1: sử dụng TreeSet và duyệt hết cây
 * Solution 2: duy trì 2 biến và dùng bfs hoặc dfs duyệt cây
 */
class Solution {

    public int findSecondMinimumValue(TreeNode root) {
        // solution 1:
        // TreeSet<Integer> treeSet = new TreeSet<>();

        // inorder(root, treeSet);
        // if (treeSet.size() == 1)
        //     return -1;
        // treeSet.pollFirst();
        // return treeSet.first();
        // solution 2:
        int minValue = root.val;
        int minValue2 = Integer.MAX_VALUE;

        Queue<TreeNode> queueTree = new LinkedList<>(List.of(root));
        boolean haveSmall = false;
        while (!queueTree.isEmpty()) {
            var tmp = queueTree.poll();

            if (tmp.val > minValue && tmp.val <= minValue2) {
                minValue2 = tmp.val;
                haveSmall = true;
            }

            if (tmp.left != null) {
                queueTree.add(tmp.left);
            }
            if (tmp.right != null) {
                queueTree.add(tmp.right);
            }
        }

        return haveSmall ? minValue2 : -1;
    }

    private void inorder(TreeNode root, TreeSet<Integer> treeSet) {
        if (root != null) {
            inorder(root.left, treeSet);
            treeSet.add(root.val);
            inorder(root.right, treeSet);
        }
    }
}

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
// 1 mang danh dau lai level do co nut ngoai cung chua (nut phai cung cua level)
// traversal nhu nao cx duoc (nen traversal theo right left root)

// cach 2: dung level traversal
// thi don gian la add queue vao va lay phan tu cuoi o moi level la okela
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        var rs = new ArrayList<Integer>();

        if (root == null)
            return rs;

        Queue<TreeNode> treeQueue = new LinkedList<>(List.of(root));

        while (!treeQueue.isEmpty()) {
            var levelSize = treeQueue.size();

            for (int i = 0; i < levelSize; i++) {
                var node = treeQueue.poll();

                if (i == levelSize - 1) {
                    rs.add(node.val);
                }

                if (node.left != null)
                    treeQueue.offer(node.left);
                if (node.right != null)
                    treeQueue.offer(node.right);
            }
        }

        return rs;
    }
}
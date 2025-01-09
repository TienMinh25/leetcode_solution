
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
// bài này sử dụng Breadth first search
// mình sẽ cần isolation level của nó tỏng queue, vậy cách nào để làm điều đó
// đó là sau mỗi lần thêm, chúng ta sẽ biết rằng queue.length là 1 cấp độ level
// (túc là số phần tử)
// thì ta chỉ pop bằng nấy số phần tử ra thôi
class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> rs = new ArrayList<>();
        Queue<TreeNode> queueTree = new LinkedList<>(List.of(root));

        while (!queueTree.isEmpty()) {
            int qLen = queueTree.size();
            double currSum = 0;

            for (int i = 0; i < qLen; i++) {
                TreeNode tmp = queueTree.poll();
                currSum += tmp.val;
                if (tmp.left != null) {
                    queueTree.add(tmp.left);
                }
                if (tmp.right != null) {
                    queueTree.add(tmp.right);
                }
            }

            rs.add(currSum / qLen);
        }

        return rs;
    }
}

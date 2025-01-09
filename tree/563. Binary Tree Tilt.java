
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Ta xem mỗi node là 1 gốc, và left subtree chứa tổng absolute difference của left subtree
// và right subtree chứa tổng absolute difference
// ta dùng depth first search
// Khi duyệt đến nút lá thì chắc chắn luôn bằng 0
// Ta dùng postorder để tính toán
class Solution {

    int sum = 0;

    public int findTilt(TreeNode root) {
        postorder(root);

        return sum;
    }

    public int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = postorder(root.left);
        int right = postorder(root.right);

        sum += Math.abs(left - right);

        return left + right + root.val;
    }
}

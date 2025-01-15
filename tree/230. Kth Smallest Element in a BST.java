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
 // cách 1: Đơn giản nhất dùng inorder traversal đến phần tử thứ k thì dừng 
 // time complexity: O(k)
 // space complexity: O(h)
 // cách 2: xây dựng min heap để extract ra k lần là oke 
 // time complexity: O(n)
 // space complexity: O(k)
class Solution {
    private int currIdx;
    private int rs;
    public int kthSmallest(TreeNode root, int k) {
        currIdx = 1;

        inorder(root, k);

        return rs;
    }

    private void inorder(TreeNode root, int k) {
        if (root != null) {
            inorder(root.left, k);

            if (currIdx == k) {
                rs = root.val;
                // using currIdx++ in here to not to run again to condition when have 
                // result k smallest
                currIdx++;
                return;
            }
            currIdx++;

            inorder(root.right, k);
        }
    }
}
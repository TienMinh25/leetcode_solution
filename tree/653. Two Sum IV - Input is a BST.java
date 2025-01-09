
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
/**
 * Solution 1: inroder traversal + two pointer
 * Time complexity: O(n)
 * space complexity: O(n)
 *
 * Solution 2: duyệt qua từng node + search for key của k - node.val
 * time complexity: O(nlogn)
 * space complexity: O(h)
 */
class Solution {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> flatTreeList = new ArrayList<>();

        inorder(root, flatTreeList);

        int i = 0, j = flatTreeList.size() - 1;

        while (i < j) {
            if (flatTreeList.get(i) + flatTreeList.get(j) == k) {
                return true;
            }

            if (flatTreeList.get(i) + flatTreeList.get(j) > k) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    private void inorder(TreeNode root, List<Integer> flatTreeList) {
        if (root != null) {
            inorder(root.left, flatTreeList);
            flatTreeList.add(root.val);
            inorder(root.right, flatTreeList);
        }
    }
}

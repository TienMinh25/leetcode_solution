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
class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
      return build(nums, 0, nums.length - 1);
  }

  private TreeNode build(int[] nums, int start, int end) {
      if (start > end) {
          return null;
      }

      // find the maximum value in this side
      int maxIdx = start;
      for (int i = start + 1; i <= end; i++)
          if (nums[i] > nums[maxIdx])
              maxIdx = i;

      var node = new TreeNode(nums[maxIdx]);
      node.left = build(nums, start, maxIdx - 1);
      node.right = build(nums, maxIdx + 1, end);

      return node;
  }
}
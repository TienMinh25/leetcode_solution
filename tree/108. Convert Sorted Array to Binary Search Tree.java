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
 * Problem: Convert a sorted array into a height-balanced Binary Search Tree (BST).
 * - A height-balanced BST is defined as a binary tree where the depth of the two subtrees 
 *   of every node never differs by more than one.
 * 
 * Solution:
 * - Use a divide-and-conquer approach:
 *   - Select the middle element of the array as the root to ensure balance.
 *   - Recursively build the left subtree from the left half of the array.
 *   - Recursively build the right subtree from the right half of the array.
 * - The base case for recursion is when the left index is greater than the right index.
 * 
 * Time Complexity: O(n), where n is the number of elements in the array.
 * Space Complexity: O(log n), due to the recursive stack depth.
 */
class Solution {

    /**
     * Converts a sorted array into a height-balanced Binary Search Tree (BST).
     * 
     * @param nums Sorted integer array.
     * @return The root node of the height-balanced BST.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null; // Edge case: empty array
        }
        
        // Call helper function to build the tree
        return convertSortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * Helper function to recursively build a height-balanced BST.
     * 
     * @param nums  Sorted array of integers.
     * @param left  Left boundary of the current subarray.
     * @param right Right boundary of the current subarray.
     * @return The root node of the subtree.
     */
    public TreeNode convertSortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null; // Base case: no elements to process
        }
        
        // Find the middle index of the current subarray
        int mid = (left + right) / 2;

        // Create a new node with the middle element as the value
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build the left subtree from the left half of the array
        root.left = convertSortedArrayToBST(nums, left, mid - 1);

        // Recursively build the right subtree from the right half of the array
        root.right = convertSortedArrayToBST(nums, mid + 1, right);

        return root; // Return the root of the subtree
    }

    /*
    // Optional debugging function to print the tree structure
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("Node value: " + root.val);
        System.out.println("Left child: " + (root.left != null ? root.left.val : "null"));
        System.out.println("Right child: " + (root.right != null ? root.right.val : "null"));
        System.out.println("-------------------");
        printTree(root.left);
        printTree(root.right);
    }
    */
}
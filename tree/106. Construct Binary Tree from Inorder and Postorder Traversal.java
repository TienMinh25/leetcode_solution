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
    private HashMap<Integer, Integer> mapping = new HashMap<>();
    private int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++)
            mapping.put(inorder[i], i);
        
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int start, int end) {
        if (start > end)
            return null;
        
        int rootVal = postorder[postIdx--];
        var node = new TreeNode(rootVal);

        node.right = build(postorder, mapping.get(rootVal) + 1, end);
        node.left = build(postorder, start, mapping.get(rootVal) - 1);

        return node;
    }
}
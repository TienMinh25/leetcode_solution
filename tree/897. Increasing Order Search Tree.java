
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

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> flatTree = new ArrayList<>();

        inorder(root, flatTree);
        TreeNode rs = new TreeNode(flatTree.get(0));
        TreeNode curr = rs;

        for (int i = 1; i < flatTree.size(); i++) {
            curr.right = new TreeNode(flatTree.get(i));
            curr = curr.right;
        }

        return rs;
    }

    public void inorder(TreeNode root, List<Integer> flatTree) {
        if (root != null) {
            inorder(root.left, flatTree);
            flatTree.add(root.val);
            inorder(root.right, flatTree);
        }
    }
}

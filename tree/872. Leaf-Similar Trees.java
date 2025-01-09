
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
class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> sequenceLeaf1 = new ArrayList<>();
        List<Integer> sequenceLeaf2 = new ArrayList<>();

        inorder(root1, sequenceLeaf1);
        inorder(root2, sequenceLeaf2);

        // int i = 0, j = 0;
        // while (i < sequenceLeaf1.size() && j < sequenceLeaf2.size()) {
        //     if (!sequenceLeaf1.get(i).equals(sequenceLeaf2.get(j))) {
        //         return false;
        //     }
        //     i++; j++;
        // }
        // if (i != sequenceLeaf1.size() || j != sequenceLeaf2.size()) {
        //     return false;
        // }
        return sequenceLeaf1.equals(sequenceLeaf2);
    }

    private void inorder(TreeNode tmp, List<Integer> sequenceLeaf) {
        if (tmp != null) {
            inorder(tmp.left, sequenceLeaf);

            if (tmp.left == null && tmp.right == null) {
                sequenceLeaf.add(tmp.val);
            }

            inorder(tmp.right, sequenceLeaf);
        }
    }
}

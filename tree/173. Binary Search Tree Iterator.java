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
class BSTIterator {
    private List<Integer> traversal = new ArrayList<>();
    private int currIdx;

    public BSTIterator(TreeNode root) {
        inorder(root);
        currIdx = 0;
    }
    
    public int next() {
        return traversal.get(currIdx++);
    }
    
    public boolean hasNext() {
        if (currIdx > traversal.size() - 1)
            return false;
        
        return true;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            traversal.add(root.val);
            inorder(root.right);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
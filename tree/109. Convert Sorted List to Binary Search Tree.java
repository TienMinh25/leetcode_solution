/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
// bài này code AVL tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int height;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    private int height(TreeNode tmp) {
        if (tmp == null)
            return 0;

        return tmp.height;
    }

    private int getBalance(TreeNode tmp) {
        if (tmp == null)
            return 0;

        return height(tmp.left) - height(tmp.right);
    }

    private TreeNode leftRotation(TreeNode root) {
        var right = root.right;

        // update pointer
        root.right = right.left;
        right.left = root;

        // update height
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        right.height = Math.max(height(right.left), height(right.right)) + 1;

        return right;
    }

    private TreeNode rightRotation(TreeNode root) {
        var left = root.left;

        // update pointer
        root.left = left.right;
        left.right = root;

        // update height
        root.height = 1 + Math.max(height(root.left), height(root.right));
        left.height = 1 + Math.max(height(left.left), height(left.right));

        return left;
    }

    private TreeNode insertAVLTree(TreeNode root, int key) {
        if (root == null)
            return new TreeNode(key);

        if (root.val > key) {
            root.left = insertAVLTree(root.left, key);
        } else if (root.val < key) {
            root.right = insertAVLTree(root.right, key);
        } else {
            return root;
        }

        // update height cua current node after insert
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // check balance
        var balanceFactor = getBalance(root);

        // if imbalance, balanced it
        // left left case -> right rotation
        if (balanceFactor > 1 && root.left.val > key) {
            return rightRotation(root);
        }

        // right right case -> left rotation
        if (balanceFactor < -1 && root.right.val < key) {
            return leftRotation(root);
        }

        // left right case --> left rotation + right rotation
        if (balanceFactor > 1 && root.left.val < key) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // right left case -> right rotation + left rotation
        if (balanceFactor < -1 && root.right.val > key) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        TreeNode root = null;

        while (head != null) {
            root = insertAVLTree(root, head.val);
            head = head.next;
        }

        return root;
    }
}
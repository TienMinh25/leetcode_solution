/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution: using binary search tree and mark parent -> can using hashmap
// time complexity: O(logn)
// space complexity: O(logn)
class Solution {
    private HashMap<Integer, Boolean> mapping = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Solution 1:
        /*
        var curr = root;
        binarySearch(curr, p.val);
        TreeNode rs = null;

        var curr2 = root;
        while (curr2 != null) {
            if (mapping.containsKey(curr2.val)) {
                rs = curr2;
            }

            if (curr2.val == q.val) {
                break;
            }

            if (curr2.val > q.val) {
                curr2 = curr2.left;
            } else {
                curr2 = curr2.right;
            }
        }

        return rs;
        */

        // Solution 2: just using binary search
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    private void binarySearch(TreeNode root, int key) {
        mapping.put(root.val, true);

        if (key == root.val) return;

        if (key > root.val) {
            binarySearch(root.right, key);
        } else {
            binarySearch(root.left, key);
        }
    }
}
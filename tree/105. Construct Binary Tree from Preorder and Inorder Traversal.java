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
 // Sử dụng mỗi phần tử preorder là root, thì tự generate + việc limit khoảng range cho inorder để 
 // biết cái nào là phần tử bên trái, cái nào là cây đi bên phải của inorder
 // + việc dùng hashmap cho value và index của inorder giúp việc tìm kiếm sẽ là O(1)
 // mà tất cả việc chỉ là traversal qua preorder, tìm phải trái là okela
 // time complexity: O(n)
 // space complexity: O(n + h) với h là độ cao của cây cho stack và n là dùng cho map
class Solution {
    HashMap<Integer, Integer> mapping = new HashMap<>();
    private int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preparing map for index and value in inorder
        for (int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i);
        }
        
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[preIdx++];
        var node = new TreeNode(rootVal);
        node.left = build(preorder, start, mapping.get(rootVal) - 1);
        node.right = build(preorder, mapping.get(rootVal) + 1, end);

        return node;
    }
}
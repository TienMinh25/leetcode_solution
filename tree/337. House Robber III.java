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
 // Think native:
 // Đối với mỗi 1 node, thì có 2 cách để lựa chọn
 // Nếu chọn rob ở node này, thì node con không rob đc
 // Nếu ko rob ở node này, thì 2 node con có thể rob đc
 // Với mỗi 2 lựa chọn này, thì ta sẽ so sánh xem cách nào okela hơn
 // Thứ 2, ta thấy rằng đối với bài toán con đối với gốc nhỏ hơn (root.left và root.right) cũng như vậy
 // Vậy nên ta có thể sử dụng recursive
 // ngoài ra bài này tính đi tính lại nhiều lần
 // dùng memorization + recursive (dp)
 class Solution {
  public int rob(TreeNode root) {
      return robTree(root, new HashMap<>());
  }

  private int robTree(TreeNode root, HashMap<TreeNode, Integer> map) {
      if (root == null) {
          return 0;
      }

      if (map.containsKey(root)) {
          return map.get(root);
      }

      int val = 0;
      if (root.left != null) {
          val += robTree(root.left.left, map) + robTree(root.left.right, map);
      }

      if (root.right != null) {
          val += robTree(root.right.left, map) + robTree(root.right.right, map);
      }

      // compare case rob root or not
      val = Math.max(val + root.val, robTree(root.left, map) + robTree(root.right, map));

      map.put(root, val);

      return val;
  }
}
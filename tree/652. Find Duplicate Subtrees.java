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
// bai nay can dung hash table luu lai subtree do da ton tai hay chua
// neu co roi thi them vao ket qua
// ket hop su dung postorder (de serialize tree)
class Solution {
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      List<TreeNode> res = new LinkedList<>();
      postorder(root, new HashMap<>(), res);
      return res;
  }

  public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
      if (cur == null)
          return "#";

      StringBuilder serial = new StringBuilder();
      serial.append(cur.val).append(",").append(postorder(cur.left, map, res))
          .append(",").append(postorder(cur.right, map, res));

      map.put(serial.toString(), map.getOrDefault(serial.toString(), 0) + 1);
      if (map.get(serial.toString()) == 2)
          res.add(cur);
      return serial.toString();
  }
}
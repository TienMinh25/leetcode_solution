/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
  // other trick =))
  static TreeNode node;

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
      /*
      StringBuilder sb = new StringBuilder();
      dfs(root, sb);

      return sb.toString();
      */
      node = root;

      return "";
  }

  private void dfs(TreeNode node, StringBuilder sb) {
      if (node != null) {
          sb.append(node.val);
          sb.append(",");
          dfs(node.left, sb);
          dfs(node.right, sb);
      }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
      /*
      if (data.length() == 0) {
          return null;
      }

      List<Integer> nodes = Stream.of(data.split(",")).map(Integer::parseInt).collect(Collectors.toList());
      TreeNode root = null;
      for (int i = 0; i < nodes.size(); i++) {
          root = insertBST(root, nodes.get(i));
      }

      return root;
      */

      return node;
  }

  private TreeNode insertBST(TreeNode node, int key) {
      if (node == null) {
          return new TreeNode(key);
      }

      if (node.val > key) {
          node.left = insertBST(node.left, key);
      } else {
          node.right = insertBST(node.right, key);
      }

      return node;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
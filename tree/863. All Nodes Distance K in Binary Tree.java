/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  // con - cha
  HashMap<TreeNode, TreeNode> parentMap;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      // step 1: save previous parent of each node
      parentMap = new HashMap<>();

      previous(root, null);

      // step 2: using bfs from target to bottom and top (because k is the same for
      // the
      // top and bottom, so oke rs if count == k -> break)
      // cach nay thi tuong tuong nhu minh dang be node con sibling voi node target
      // len
      HashSet<TreeNode> visited = new HashSet<>();
      Queue<TreeNode> queueTree = new LinkedList<>(List.of(target));
      visited.add(target);
      visited.add(null);
      int count = 0;

      while (!queueTree.isEmpty()) {
          var sizeOfQueue = queueTree.size();

          if (count == k)
              break;
          while (sizeOfQueue-- > 0) {
              var node = queueTree.poll();

              if (node.left != null && !visited.contains(node.left)) {
                  queueTree.offer(node.left);
                  visited.add(node.left);
              }

              if (node.right != null && !visited.contains(node.right)) {
                  queueTree.offer(node.right);
                  visited.add(node.right);
              }

              if (!visited.contains(parentMap.get(node))) {
                  queueTree.offer(parentMap.get(node));
                  visited.add(parentMap.get(node));
              }
          }
          count++;
      }

      List<Integer> rs = new ArrayList<>();

      while (!queueTree.isEmpty()) {
          rs.add(queueTree.poll().val);
      }

      return rs;
  }

  private void previous(TreeNode root, TreeNode parent) {
      if (root == null)
          return;

      parentMap.put(root, parent);

      previous(root.left, root);
      previous(root.right, root);
  }
}
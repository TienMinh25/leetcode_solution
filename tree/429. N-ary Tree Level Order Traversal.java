/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
      List<List<Integer>> rs = new ArrayList<List<Integer>>();

      if (root == null) {
          return rs;
      }

      Queue<Node> queueTree = new LinkedList<>(List.of(root));

      while (!queueTree.isEmpty()) {
          var levelSize = queueTree.size();
          var temp = new ArrayList<Integer>();

          for (int i = 0; i< levelSize; i++) {
              var parentNode = queueTree.poll();

              temp.add(parentNode.val);

              parentNode.children.forEach(node -> queueTree.add(node));
          }

          rs.add(temp);
      }

      return rs;
  }
}
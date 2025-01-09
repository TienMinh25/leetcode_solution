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
}
*/

class Solution {
    List<Integer> rs = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (var node : root.children) {
                postorder(node);
            }

            rs.add(root.val);
        }

        return rs;
    }
}
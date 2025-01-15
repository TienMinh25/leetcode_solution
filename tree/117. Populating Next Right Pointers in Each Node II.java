/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        
        Queue<Node> queueTree = new LinkedList<>(List.of(root));

        while (!queueTree.isEmpty()) {
            var levelSize = queueTree.size();
            
            for (int i = 0; i < levelSize; i++) {
                var node = queueTree.poll();

                if (i == levelSize - 1) {
                    node.next = null;
                } else {
                    var nodeNext = queueTree.peek();

                    node.next = nodeNext;
                }

                if (node.left != null)
                    queueTree.offer(node.left);

                if (node.right != null)
                    queueTree.offer(node.right);
            }
        }   

        return root;
    }
}
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
  public Node intersect(Node quadTree1, Node quadTree2) {
      if (quadTree1.isLeaf && quadTree2.isLeaf) {
          quadTree1.val |= quadTree2.val;
          
          return quadTree1;
      }

      if (quadTree1.isLeaf || quadTree2.isLeaf) {
          Node leaf = quadTree1.isLeaf ? quadTree1 : quadTree2;
          
          if (leaf == quadTree1 && quadTree1.val) {
              return quadTree1;
          }

          if (leaf == quadTree2 && quadTree2.val) {
              return quadTree2;
          }

          if (leaf == quadTree1) {
              return quadTree2;
          }
          
          return quadTree1;
      }

      var node1 = intersect(quadTree1.topLeft, quadTree2.topLeft);
      var node2 = intersect(quadTree1.topRight, quadTree2.topRight);
      var node3 = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
      var node4 = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

      if (node1.val == node2.val && node2.val == node3.val 
          && node3.val == node4.val && node1.isLeaf && node2.isLeaf && node3.isLeaf && node4.isLeaf) {
          return new Node(node1.val, true, null, null, null, null);
      }

      Node node = new Node();

      node.val = quadTree1.val | quadTree2.val;
      node.topLeft = node1;
      node.topRight = node2;
      node.bottomLeft = node3;
      node.bottomRight = node4;

      return node;
  }
}
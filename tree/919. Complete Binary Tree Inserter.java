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
class CBTInserter {
  private List<TreeNode> listNode;

  public CBTInserter(TreeNode root) {
      this.listNode = new ArrayList<>();

      Queue<TreeNode> queueTree = new LinkedList<>(List.of(root));

      while (!queueTree.isEmpty()) {
          var sizeOfLevel = queueTree.size();

          for (int i = 0; i < sizeOfLevel; i++) {
              var node = queueTree.poll();
              listNode.add(node);
              
              if (node.left != null) {
                  queueTree.offer(node.left);
              }

              if (node.right != null) {
                  queueTree.offer(node.right);
              }
          }
      }
  }
  
  public int insert(int val) {
      var newNode = new TreeNode(val);
      this.listNode.add(newNode);
      int subIdx = listNode.size() - 1;
      int parentIdx = (subIdx - 1) >> 1;

      if (parentIdx * 2 + 1 == subIdx) {
          listNode.get(parentIdx).left = newNode;
      } else {
          listNode.get(parentIdx).right = newNode;
      }

      return listNode.get(parentIdx).val;
  }
  
  public TreeNode get_root() {
      return this.listNode.get(0);
  }
}

/**
* Your CBTInserter object will be instantiated and called as such:
* CBTInserter obj = new CBTInserter(root);
* int param_1 = obj.insert(val);
* TreeNode param_2 = obj.get_root();
*/
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
/**
 * root -> left -> right
 * preorder = [1, 2, 4, 5, 3, 6, 7]
 * index. 0 1 2 3 4 5 6
 * 
 * left -> right -> root
 * postorder = [4, 5, 2, 6, 7, 3, 1]
 * index: 0 1 2 3 4 5 6
 * 
 * (1, 2, 3) -> (0, 1, 2)
 * (4, 5, 6) -> (3, 4, 5)
 * (0) -> (6)
 * Chia khoảng ra ta thấy rằng: chọn root qua từng khoảng, ta sẽ chia được
 * khoảng nào sẽ xét cho left
 * và right
 * ví dụ ở đây: 1 là root, sau đó xét tiếp đến 2, thấy 2 là root
 * ==> leftSide: 0 -> 1
 * ==> rightSide: 3 -> 5
 * tương tự như vậy cho các level dưới -> divide and conquer
 * tức nếu đưa về bài toán con chỉ còn 1 node ==> left side = null, right side =
 * null
 * thế nhưng mà làm sao để chia được left side và right side?
 * 
 */
class Solution {
  // save index for postorder to find the split
  private HashMap<Integer, Integer> indexPost;
  private int currIdx;

  public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
      indexPost = new HashMap<>();
      currIdx = 0;

      for (int i = 0; i < postorder.length; i++) {
          indexPost.put(postorder[i], i);
      }

      return build(preorder, postorder, 0, postorder.length - 1);
  }

  public TreeNode build(int[] preorder, int[] postorder, int startPost, int endPost) {
      if (currIdx >= preorder.length) {
          return null;
      }

      TreeNode node = new TreeNode(preorder[currIdx]);

      if (startPost == endPost) {
          return node;
      }

      var indexSplit = indexPost.get(preorder[currIdx + 1]);
      if (startPost > indexSplit) {
          node.left = null;
      } else {
          currIdx++;
          node.left = build(preorder, postorder, startPost, indexSplit);
      }

      if (indexSplit + 1 > endPost - 1) {
          node.right = null;
      } else {
          currIdx++;
          node.right = build(preorder, postorder, indexSplit + 1, endPost - 1);
      }

      return node;
  }
}

/**
* pre: 3 4 1 2
* post: 1 4 2 3
* 
* currIdx: 0
* 
* build(preorder, postorder, 0, 3);
* node: 3
* node.left = 0 -> 1
* currIdx = 1
* node: 4
* indexSplit = 0
* node.left = 0 -> 0 -> 1
* currIdx = 2
* node.right = 1 -> 0 -> null
* currIdx = 3
* 
* node.right = 2 -> 2
* 
* 
*/
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/
// dung chia de tri o day
// y tuong nhu nay:
// ta co the thay rang:
// base case o day se la 1 o trong grid, vi grid do thi chi co duy nhat 1 phan tu duy nhat thoi
// cac truong hop lon khac thi se chia nho dan den phan tu nho nhat roi build len
// vay nen bai nay code de quy cung okela
// lam cach nao de build up them thong tin ve grid vung do co dong nhau hay ko va gia tri la gi
// node co value :D? thi lay value ma soi
class Solution {
  public Node construct(int[][] grid) {
      int rolCol = grid.length; 
      return constructNode(grid, 0, rolCol - 1, 0, rolCol - 1);
  }

  private Node constructNode(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
      if (rowStart > rowEnd || colStart > colEnd) {
          return null;
      }

      // check rowStart -> rowEnd, colStart -> colEnd ==> neu cung 1 value ==> 1 node leaf
      // neu la node leaf => return luon, okela
      // neu khong phai node leaf ==> val khac nhau => contructNode recursive
      int first = grid[rowStart][colStart];
      boolean isLeaf = true;

      for (int i = rowStart; i <= rowEnd; i++) {
          for (int j = colStart; j <= colEnd; j++) {
              if (grid[i][j] != first) {
                  isLeaf = false;
                  break;
              }
          }
      }

      Node node;

      if (isLeaf == false) {
          node = new Node(true, isLeaf);
          int colDivide = (colStart + colEnd) >> 1;
          int rowDivide = (rowStart + rowEnd) >> 1;

          node.topLeft = constructNode(grid, rowStart, rowDivide, colStart, colDivide);
          node.topRight = constructNode(grid, rowStart, rowDivide, colDivide + 1, colEnd);
          node.bottomLeft = constructNode(grid, rowDivide + 1, rowEnd, colStart, colDivide);
          node.bottomRight = constructNode(grid, rowDivide + 1, rowEnd, colDivide + 1,  colEnd);
      } else {
          node = new Node(first == 1 ? true : false, isLeaf);
      }

      return node;
  }
}
/**
- Solution 1: sử dụng brute force để duyệt qua và xử lý từng ô một trong mảng
time complexity: O(n*m*9), space complexity: O(1)

- Solution 2: sử dụng kĩ thuật precomputation (prefix sum) ở đây
cụ thể hơn thì tính prefix sum theo hàng dọc =))
vì để ý thấy ví dụ sau:
1  2  3  4
6  7  8  9
11 12 13 14
==> prefix sum:
1  2  3  4
7  9  11 13
18 21 24 27
tính cho phần tử 8 trong mảng thì ta thấy tổng sẽ bằng
tổng cũ của 7 + prefixSum[hàng dọc cuối] - prefixSum[hàng dọc đầu]
*/
class Solution {
  public int[][] imageSmoother(int[][] img) {
      int[][] result = new int[img.length][img[0].length];

      for (int i = 0; i < img.length; i++) {
          for (int j = 0; j < img[0].length; j++) {
              result[i][j] = smoothen(img, i, j);
          }
      }
      
      return result;
  }

  int smoothen(int[][] img, int x, int y) {
      int sum = 0;
      int count = 0;

      for (int i = -1; i <= 1; i++) {
          for (int j = -1; j <= 1; j++) {
              int row = x + i;
              int col = y + j;

              if (row < 0 || col < 0 || row >= img.length || col >= img[0].length)
                  continue;

              sum += img[row][col];
              count++;
          }
      }

      return sum/count;
  }
}
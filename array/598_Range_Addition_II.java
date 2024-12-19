/*
 * Solution 1: using brute force --> biến mảng 2 chiều thành mảng 1 chiều
 * bằng công thức:
 * column * i + k
 * với i limit by limit row
 * với k limit by limit col
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * m = 3, n = 3
 * 0 0 0 0 0 0 0 0 0
 * 3*2
 * 3*1
 * col * i + k --> k limit by limit col
 * for i = 0; i < row; i++
 * x y
 * 
 * Solution 2:
 * Ta nhận thấy tại sao ta phải cộng vào array 1 chiều rồi mới tìm max
 * Thay vì đó ta có thể tổng hợp từ ops và tìm ra được phần tử có giá trị lớn nhất
 * Và số lượng là bao nhiêu
 * Ta thấy nếu một vị trí trong array được cộng trước, thì những vị trí khác không được cộng ta sẽ
 * không quan tâm đến nữa -> vì không bao giờ nó là giá trị max
 * Thứ 2, ta để ý thấy rằng số lượng max đạt được chắc chắn sẽ 
 * bằng min(ops[i][0]) * min(ops[i][1]) với 0 <= i < ops.length 
 */
class Solution {
  public int maxCount(int m, int n, int[][] ops) {
      // Solution 1: using brute force
      /*
      int[] matrix = new int[m * n];

      Arrays.fill(matrix, 0);

      for (var op : ops) {
          int limitRow = op[0], limitCol = op[1];

          for (int i = 0; i < limitRow; i++) {
              for (int j = 0; j < limitCol; j++) {
                  matrix[n * i + j] += 1;
              }
          }
      }

      int maxElement = 0;
      int result = 0;

      for (int i = 0; i < m * n; i++) {
          if (matrix[i] > maxElement) {
              maxElement = matrix[i];
              result = 1;
          } else if (matrix[i] == maxElement) {
              result++;
          }
      }

      return result;
      */

      // Solution 2: tricky =))
      int minElementRow = Integer.MAX_VALUE, minElementCol = Integer.MAX_VALUE;

      if (ops.length == 0) {
          return m * n;
      }

      for (var op : ops) {
          minElementRow = Math.min(minElementRow, op[0]);
          minElementCol = Math.min(minElementCol, op[1]);
      }

      return minElementRow * minElementCol;
  }
}

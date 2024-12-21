/**
 * Solution:
 * - Duyệt qua từng vị trí của luống hoa, với mỗi index, kiểm tra xem ô đất bên
 * trái và ô đất bên phải có còn trống không
 * (việc trống không này có 2 tricky cases ở đây, đó là left ở vị trí index 0 và
 * right vị trí index flowerbed.length - 1)
 * - Sau đó nếu vị trí index hiện tại còn trống (tức là có value = 0) và left và
 * right đều trống => trồng hoa đồng thời giảm n
 * - Sau đó chỉ việc kiểm tra xem n <= 0 hay không, nếu đúng thì ==> trồng đc
 * hết
 * - Bài này áp dụng greedy algorithm
 */
class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
      for (int i = 0; i < flowerbed.length; i++) {
          boolean left = i == 0 || flowerbed[i - 1] == 0;
          boolean right = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

          if (left && right && flowerbed[i] == 0) {
              n--;
              flowerbed[i] = 1;
          }
      }

      return n <= 0;
  }
}
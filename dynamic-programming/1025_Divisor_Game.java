/**
 * Solution: sử dụng kĩ thuật dynamic programming
 * Phân tích bài toán:
 * - Alice đi trước -> nếu n = 1 -> Alice thua
 * - Được chọn 1 số x thỏa mãn: 0 < x < n, n % x == 0
 * - thay thế số n = n - x
 * Vì 2 người chơi đều chơi optimally ==> đều hướng tới sao cho đến lượt đối thủ
 * sẽ thì n trên bảng sẽ là 1
 * 
 * Thinking:
 * Với n còn trên bảng, ta sẽ xem có bao nhiêu số có thể là ước của n :)?
 * Sau đó thử hết?, thế thì cần trường hợp nào để win?
 * Nếu người chơi bị dính vào n = 1 --> chắc chắn thua
 * Nếu người chơi dính vào n = 2 --> chắc chắn thắng
 * Nếu n > 2 --> thì n luôn chắc chắn có thể giảm về 2
 * ==> Cả Alice và Bob đều cố gắng cho lượt chơi của mình có thể giảm về 2
 * 
 * B1: Xác định trạng thái bài toán
 * Trạng thái bài toán là đối với số i (i <= n), Alice có thể thắng được đối với số i bắt đầu
 * tức là nếu có thể có cách giảm về 2 thì chắc chắc thắng rồi =))
 * Bởi vì nếu bài toán i có thể thắng, mà Alice có thể giảm từ n về i ==> Alice
 * chấc chắn có thể thắng
 * 
 * dp[i] sẽ là hàm đại diện cho việc có thể thắng được không
 * ==> Kết quả bài toán cuối cùng sẽ là dp[n]
 * 
 * B2: Liên hệ giữa các trạng thái (build bottom up)
 * Đối với mỗi ước của số n (tức là số i khi xét), sẽ có 2 trường hợp:
 * + Nếu dp[i - x] = true --> tức là khi trừ đi sẽ là Bob win, vì Alice chơi
 * trước
 * ==> dp[i] sẽ lose ( với x là ước của i)
 * + Nếu dp[i] đã win, thì gán lại dp[i] = dp[i], vì đang duyệt qua hết các ước,
 * có khả năng dp[i-x] sẽ bằng false
 * mà trường hợp này thì ta không muốn bị ghi đè nếu dp[i] đã là true -> vì ở số
 * i, có khả năng Alice thắng
 * Ta thấy, nếu n = 1 --> false, n = 2 --> true

 ==> Công thức: dp[i] = dp[i] | dp[i-j]
 */
class Solution {
  public boolean divisorGame(int n) {
      // base case
      if (n == 1) {
          return false;
      }

      if (n == 2) {
          return true;
      }

      boolean[] dp = new boolean[n + 1];

      dp[2] = true;

      for (int i = 3; i <= n; i++) {
          for (int j = 1; j <= i >> 1; j++) {
              if (i % j == 0) {
                  dp[i] = dp[i] | !dp[i - j];
              }
          }
      }

      return dp[n];
  }
}
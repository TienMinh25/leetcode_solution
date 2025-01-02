/**
 * Đề bài: Cho một xâu S. Ở mỗi bước, bạn An có thể chèn 1 kí tự tuỳ ý vào bất kì vị trí nào trong xâu S
 * Hãy tính số bước ít nhất cần thực hiện để biến xâu S thành xâu đối xứng
 * 
 * Điều kiện: 1 <= |S| <= 5000
 * 
 * ==> Ta thấy có 1 operation duy nhất:
 * chèn 1 kí tự bất kì vào 1 vị trí bất kì
 * 
 * Có 2 cách:
 * C1: Từ ý tưởng của bìa toán xâu con chung dài nhất, ta có thuật toán như sau:
 * Gọi P là xâu đảo của S và T là xâu con chung dài nhất của S và P. Khi đó các kí tự của S không thuộc T
 * cũng là các kí tự cần thêm vào để S trở thành đối xứng. Đáp số của bài toán sẽ là n - k, với k là độ
 * dài của T
 * 
 * C2: (cách này dễ hơn, và thường nghĩ đến tốt hơn) (đầu tiên nghĩ đến two pointer và có thể nghĩ ra nó
 * và làm nó đúng bằng dynamic programming)
 * Nghĩ về two pointer ở đây (left và right)
 * Đi từ ý tưởng ban đầu, xét left và right, với left đi từ trái, right đi từ phải, nếu khác nhau ==> cần insert
 * tuy nhiên nếu làm vậy chắc chắn sai với 1 vài trường hợp
 * Ví dụ: ass -> 1, nhưng nếu làm left và right khi nghĩ đến two pointer, có thể ra kết quả 1 (assa), có thể ra kết quả 
 * là ssass (kết quả là 2), phụ thuộc vào input và cách code -> dù cách code nào thì cũng sẽ có trường hợp
 * sai được
 * 
 * B1: Xác định trạng trạng thái bài toán:
 * Gọi dp[i][j] là số kí tự ít nhất cần chèn vào xâu S[i..j] để xâu S[i..j] trở thành xâu đối xứng
 * dp[i][j] là trạng thái bài toán
 * 
 * B2: Liên hệ trạng thái bài toán:
 * Nhận thấy: dp[i][i] = 0 --> Vì ở đó không cần thêm gì, nó đã đối xứng sẵn
 * 
 * Nếu xét với mỗi left và right ở 2 phía
 * Ta thấy: 
 * Nếu s[left] == s[right] ==> dp[left][right] = dp[left + 1][right - 1]
 * Nếu s[left] != s[right] thì sao?
 *  Có 2 cách để chèn:
 *    trước đó, cần lấy ở đâu? lấy ở cái xâu nào đã tính toán từ trước
 *    cách 1 (chèn bên trái, chèn ngay vị trí left) --> dp[left][right] = dp[left + 1][right] + 1
 *    cách 2 (chèn bên phải, chèn ngay vị trí right) --> dp[left][right] = dp[left][right - 1] + 1
 * 
 *  ==> dp[left][right] = min(dp[left - 1][right], dp[left][right - 1]) + 1
 *                
 * Tổng quát lại, ta có công thức:
 * dp[i][i] = 0
 * dp[left][right] = dp[left + 1][right - 1]                            nếu s[left] == s[right]
 * dp[left][right] = min(dp[left + 1][right], dp[left][right - 1]) + 1; nếu s[left] != s[right]
 * 
 * B3: Xác định kết quả bài toán:
 * dp[1][n] 
 */
public class palindrome {
  int[][] dp = new int[5010][5010];

  public int solve(String s) {
    int n = s.length();

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = -1;
      }
    }

    return calc(1, n, s);
  }

  public int calc(int i, int j, String s) {
    if (dp[i][j] == -1) {
      if (i >= j) {
        dp[i][j] = 0;
      }
      else {
        if (s.charAt(i) == s.charAt(j))
          dp[i][j] = calc(i + 1, j - 1, s);
        else 
          dp[i][j] = 1 + Math.min(calc(i, j - 1, s), calc(i + 1, j, s));
      }
    }

    return dp[i][j];
  }
  
  public static void main(String[] args) {
    var test = new palindrome();

    var result = test.solve("ass");

    System.out.println(result);
  }
}

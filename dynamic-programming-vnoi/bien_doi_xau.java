
/**
 * Bài toán: (để thuận tiện về trình bày và tính toán, quy ước xâu đều bắt đầu từ 1)
 * Cho 2 xâu A và B có độ dài là m và n, bắt đầu từ chỉ số 1. Ta muốn biến đổi xâu A về xâu B
 * qua 1 số phép biến đổi sau đây:
 * Chèn 1 kí tự
 * Thay thế 1 kí tự
 * Xoá 1 kí tự
 * Hãy tìm số ít nhất các phép biến đổi để biến đổi xâu A thành xâu B
 *
 * constraints:
 * 1 <= n * m <= 10^6
 *
 * B1: Xác định trạng thái bài toán:
 * Đặt Ai là xâu gồm i kí tự đầu tiên của A, Bj là xâu gồm j kí tự đầu tiên của B.
 * Quy ước A0 và B0 là 2 xâu rỗng (có 0 kí tự)
 *
 * Ý tưởng bài toán này là quy hoạch động
 */
public class bien_doi_xau {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }
}

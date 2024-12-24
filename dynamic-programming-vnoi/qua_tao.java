
/**
 * Bài toán: 
 * Cho 1 bảng ô vuông m x n (m hàng, n cột), ở mỗi ô có số lượng táo (a[i][j]). 
 * Bạn An muốn đi từ (1, 1) -> (m, n)
 * 
 * Mỗi bước đi có thể di chuyển xuống dưới hoặc sang bên phải. Bạn An có thể lấy số táo của ô đi qua.
 * Tính số quả táo nhiều nhất mà An có thể lấy được.
 * Constraints:
 * 1 <= m * n <= 10^6
 * 1 <= a[i][j] <= 10^9
 * 
 * Solution: nhận diện bài toaán ==> cho mục tiêu (số táo), tìm số lượng nhiều nhất của táo 
 * ==> có thể sử dụng kĩ thuật dynamic programming
 * 
 * B1: Xác định trạng thái bài toán:
 * Gọi dp[i][j] là số táo nhiều nhất đạt được khi đi đến ô hàng i cột j, dp[i][j] là trạng thái bài toán
 * 
 * B2: Liên hệ trạng thái
 * Ta thấy, khi đi đến hàng i cột j, thì ta có 2 cách có thể đi
 * Đi từ trên xuống hoặc đi từ trái sang ==> ta mong muốn cos thể lấy số lượng táo nhieuef nhất
 * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
 * B3: Xsac định kết quả bài toán
 * dp[m][n]
 */public class qua_tao {

    public static void main(String[] args) {
        int[][] arr = new int[][]{new int[]{1, 1, 1}, new int[]{2, 3, 1}, new int[]{1, 5, 1}};
        System.out.println(solve(3, 3, arr));
    }

    public static int solve(int m, int n, int[][] arr) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}


import java.util.Arrays;

/**
 * Phân tích bài toán: 
 * Cho dãy số nguyên dương gồm n phần tử, tìm độ dài của dãy con không giảm dài nhát của dãy
 * B1: Xác định trạng thái bài toán 
 * Tranjg thái bài toán là độ dài của dãy con không giảm dài nhất 
 * kết thúc ở vị trí i ( i <= n ) (không xét theo index)
 * B2: Liên hệ giữa các trạng thái
 * Gọi f[i] là độ dài của dãy con không giảm dài nhất kết thúc tại a[i] (cái chữ
 * kết thúc ở vị trí i) tức laf dãy con đó kết thúc tại i * và thằng i là thằng
 * chốt (tức là nó có trong dãy đó) hiểu chưa?
 * Neueeeus như vậy ta thấy:
 * Với j < i mà a[j] <= a[i] thì ==> có thể thêm a[j] vào mảng không giảm dài
 * nhất của dãy ==> dp[i] = Math.max(dp[i], dp[j] + 1)
 * 4 3 4 1 5 7 5 4 6
 * dp:
 * 1 1 2 1 3 4 4 3
 * B3: Xác định kết quả
 * max(dp[i]) vói i chạy từ [0, n)
 */
public class do_dai_day_con_dai_nhat {

    public static int solve(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] >= arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (var x : dp) {
            result = Math.max(x, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 4, 1, 5, 7, 5, 4};
        System.out.println("Độ dài của dãy con không giảm lớn nhất là: " + solve(arr));
    }
}

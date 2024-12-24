
import java.util.Arrays;

/**
 * Bài toán: dãy số waivo: 
 * 1 dãy goomf k số, 1 dãy được gọi là dãy số waivo nếu tồn tại 1 số tự nhiên 1 <= m <= k sao cho:
 * a[1] <= a[2] <= ... <= a[m]
 * a[k] <= a[k-1] <= ... <= a[m]
 * 
 * Cho một dãy gồm n số nguyên, hãy chỉ ra một dãy con Waivo có độ dài lớn nhất trích ra từ dãy đó. 
 * Ta xem xét có thể dưa về dạng bài dãy con không giảm dài nhất
 * Ta thấy bên phải và bên trái của 1 số sẽ là dãy con không giảm
 * 
 * ==> Xác định trạng thái bài toán:
 * Gọi left[i] là độ dài của dãy số không giảm dài nhất kết thúc ở a[i] và đi từ trái sang
 * Gọi right[i] là độ dài của dãy số không giảm dài nhất kết thúc ở a[i] và đi từ phải sang
 * 
 * ==> Liên hệ giữa các trạng thái * Xét j < i và A[j] <= A[i] => left[i] = max(left[i],left[j] + 1);
 * Xét k > i và A[k] <= A[i] => right[i] = max(right[i], right[k] + 1);
 * 
 * ==> Xác định kết quả
 * rs = max(rs, left[i] + right[i] - 1) (0 <= i < n)
 */
public class day_so_waivo {

    public static int solve(int n, int[] arr) {
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] >= arr[j]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] >= arr[j]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            result = Math.max(result, left[i] + right[i] - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, -10, 5, 2, 1};
        System.out.println(solve(arr.length, arr));
    }
}

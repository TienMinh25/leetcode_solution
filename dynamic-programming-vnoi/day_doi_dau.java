
import java.util.Arrays;

/**
 * Gọi Q[i] là số phần tử của dãy con đổi dấu có phần tử cuối cùng là ai và
 * phần tử cuối cùng lớn hon phần tử đứng trước
 * 
 * Gọi P[i] là số phần tử của dãy con đổi dấu có phần tử cuối cùng là ai và phần tử cuối cùng bé hơn phần tử
 * đứng trước 
 * 
 * B2: Liên hệ trạng thái
 * Ta dễ dàng nhận ra: 
 * Với i >= j + L và:
 * A[i] > A[j] -> Q[i] = max(Q[i], P[j] + 1) (tại sao lại là P[j], vì đó
 * là phần tử cuối trước đó mà bé hơn phần tử đứng trước nó)
 * A[i] < A[j] -> P[i] = max(P[i], Q[j] + 1)
 */
public class day_doi_dau {

    public int solve(int n, int L, int U, int[] arr) {
        int[] P = new int[n];
        int[] Q = new int[n];
        Arrays.fill(P, 1);
        Arrays.fill(Q, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i - L; j++) {
                if (arr[i] > arr[j] && arr[i] - arr[j] <= U) {
                    Q[i] = Math.max(Q[i], P[j] + 1);
                }
                if (arr[i] < arr[j] && arr[j] - arr[i] <= U) {
                    P[i] = Math.max(P[i], Q[j] + 1);
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, Math.max(P[i], Q[i]));
        }
        return result;
    }
}

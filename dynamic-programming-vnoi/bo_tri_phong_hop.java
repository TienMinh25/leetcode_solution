
import java.util.Arrays;

/**
 * Bài toán: Có n cuộc họp cuộc họp thứ i bắt đầu vào Ai và kết thúc tại Bi( thời điểm)
 * Do chỉ có 1 phòng hội thảo ==> các phòng họp sẽ đc bố trí 1 là
 * giao nhau tại đầu mút, 2 là không giao nhau * Hãy bố trí phòng hop nhiều nhất
 * có thể
 * constraint:
 * 1 <= n <= 1000
 * 1 <= Ai <= Bi <= 10^9
 * 
 * Nhận thấy: cuoojc họp bắt đầu càng sớm ==> số luonjg cuộc họp
 * càng nhiều ==> sort theo thời điểm bắt đầu của cuộc họp
 * Đúng là biếnthể của dãy con không giảm dài nhất =)) được
 * 
 * Có thể phát biểu lại bài toán: Tìm dãy con khoong giảm dài nhất của thời điểm kết thúc của ai và
 * thời điểm bắt đầu của aj (với i < j) * Ta thấy nữa là mỗi 1 cuoojc họp thì đều là 1 -> vif số lượng là 1 =))
 * 
 * Hoặc có thể phsat biểu lại là:
 * Tìm dãy con cuộc họp dài nhất sao cho thỏa man điều kiện cuộc họp j được bố trí 
 * sau cuộc họp i (j < i) và (Bj <= Ai)
 * 
 * B1: Xác định trạng thái bài toán
 * Trạng thái bài toán là độ dài của dãy con cuộc họp dài 
 * nhất sao cho thỏa man điều kiện cuộc họp j được bố trí sau cuộc họp i (j < i) và (Bj <= Ai)
 * 
 * B2: Liên heje trạng thái bài toán
 * Gọi hàm dp[i] là độ dài của dãy con dãy con cuộc họp dài nhất sao cho thỏa
 * man điều kiện cuộc họp j được bố trí sau cuộc họp i (j < i) và (Bj <= Ai)
 * 
 * Vậy với j < i, nếu meetings[j].end <= meetings[i].start * ==> Nếu dp[j] + 1 > dp[i] 
 * ==> cập nhật dp[i], nếu không thì giữ nguyên * dp[i] = max(dp[i],dp[j+1])
 * 
 * B3: Xác định kết quả
 * max(dp[i])
 */
public class bo_tri_phong_hop {

    static class Meeting {

        public int start;
        public int end;
        public int num;

        public Meeting(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Meeting[] arr = new Meeting[]{new Meeting(1, 4, 1), new Meeting(3, 6, 2), new Meeting(2, 3, 3)};
        System.out.println(solve(arr.length, arr));
    }

    public static int solve(int n, Meeting[] arr) {
        Arrays.sort(arr, (m1, m2) -> {
            if (m1.start > m2.start) {
                return 1;
            } else if (m1.start < m2.start) {
                return -1;
            } else {
                if (m1.end > m2.end) {
                    return 1;
                } else if (m1.end < m2.end) {
                    return -1;
                }
            }
            return 0;
        });
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].start >= arr[j].end) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (var x : dp) {
            result = Math.max(x, result);
        
        }return result;
    }
}

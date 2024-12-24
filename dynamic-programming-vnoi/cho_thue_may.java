
import java.util.Arrays;

/**
 * Biến thể của bài toán timf độ dài dãy con không giảm dài nhất
 *
 * Bài toán: Cả trung tâm chỉ có 1 máy cho thuê Có n đơn của khách hàng. Khách
 * hàng thứ i muốn sử dụng máy trong thời gian từ ai -> bi, trả tiền thuê là ci
 * Hãy bố trí lịch thuê để tổng tiền thu được nhiều nhất mà thời gian sử dụng
 * máy của 2 khách không giao nhau
 *
 * Phân tích bài toán: Nhận thấy rằng việc cho thuê máy càng sớm ==> tiền càng
 * nhiều ==> sort đầu vào theo thời gian ai
 *
 * Phát biểu lại bài toán: Với bài toán này, ta có thể đưa về bài toán tìm dãy
 * con có tổng lớn nhất sao cho mỗi phần tử thỏa mãn điều kiện với (i < j) thì
 * bi <= aj
 *
 * Solution: B1: Xác định trạng thái bài toán: Gọi dp[i] là tổng dãy con lớn
 * nhất kết thúc tại booking[i] dp[i] là trạng thái bài toán
 *
 * B2: Tìm liên hệ giữa các trạng thái dp[i] = booking[i].cost (vì mỗi phần tử
 * đã là 1 dãy con rồi)
 *
 * Ta thấy: * Nếu booking[i].end <= booking[j].start và i < j ==> Nếu dp[i] +
 * booking[j].cost > dp[j] ==> cập nhật dp[j] = dp[i] + booking[j].cost B3: Xác
 * định kết quả * max(dp[i]) (0 <= i < n) vì sao à? vì là mỗi vị trí i, mình đã
 * coi đó là kết thúc của dãy con có tổng lớn nhất rồi =))
 */
public class cho_thue_may {

    static class Booking {

        int start;
        int end;
        int cost;

        public Booking(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Booking[] bookings = new Booking[]{new Booking(1, 4, 10), new Booking(2, 3, 2), new Booking(3, 6, 3)};
        System.out.println("Số tiền lớn nhất thu được là: " + solve(bookings.length, bookings));
    }

    public static int solve(int n, Booking[] bookings) {
        Arrays.sort(bookings, (b1, b2) -> {
            if (b1.start < b2.start) {
                return -1;
            } else if (b1.start > b2.start) {
                return 1;
            } else {
                if (b1.end < b2.end) {
                    return -1;
                } else if (b1.end > b2.end) {
                    return 1;
                }
            }
            return 0;
        });
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = bookings[i].cost;

        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (bookings[i].start >= bookings[j].end) {
                    dp[i] = Math.max(dp[i], dp[j] + bookings[i].cost);
                }
            }
        }
        var result = Integer.MIN_VALUE;
        for (var x : dp) {
            result = Math.max(x, result);

        }
        return result;
    }
}

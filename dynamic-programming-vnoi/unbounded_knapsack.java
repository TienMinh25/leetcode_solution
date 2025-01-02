/*
 * Mô hình: Có n đồ vật, vật thứ i có trọng lượng Ai và giá trị Bi
 * Hãy chọn ra một số các đồ vật để xếp vào vali có trọng lượng tối đa W sao cho
 * tổng giá trị của vali là lớn nhất (Chú ý mỗi vật có thể chọn nhiều lần)
 * 
 * Constraints:
 * 1 <= n * W <= 10^6
 * 1 <= Ai, Bi <= 10^9
 * 
 * NOTE: Bài này khác bài Xếp vali (Knapsack) ở chỗ mỗi vật không phải là duy nhất và có thể chọn được vào
 * vali nhiều lần
 * 
 * B1: Xác định trạng thái bài toán
 * Trạng thái của bài toán phụ thuộc vào 2 yếu tố: số vật đang được chọn và tổng khối lượng của chúng
 * 
 * Gọi dp[i][j] là giá trị lớn nhất của vali khi ta có thể chọn các vật từ 1 -> i sao cho không vượt quá 
 * trọng lượng j
 * 
 * dp[i][j] chính là trạng thái bài toán
 * 
 * B2: Liên hệ giữa các trạng thái
 * Ta có thể dễ dàng nhận ra:
 * dp[i][0] = 0
 * dp[0][j] = 0
 * 
 * Khi xét đến vật i, xảy ra 2 TH:
 * Lấy hoặc không
 * NẾu không lấy: dp[i][j] = dp[i - 1][j]
 * Nếu lấy: dp[i][j] = max(dp[i - 1][j], dp[i][j - A[i]] + B[i])
 * 
 * B3: Xác định kết quả
 * dp[n][W] --> khi không vượt quá
 */
public class unbounded_knapsack {
  
}

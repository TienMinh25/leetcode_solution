
/**
 * knapsack (ba lô)
 * Mô hình:
 * Có n đồ vật, vật thứ i có trọng lượng A[i] và giá trị B[i]. 
 * Hãy chọn ra một số các đồ vật, mỗi vật một cái để xếp vào 1 vali có trọng lượng tối đa là W 
 * sao cho tổng giá trị của vali là lớn nhất
 * 
 * Bài này có đầu bài ví dụ:
 * W = 20
 * A = [1, 7, 6, 4, 5, 2, 3, 9]
 * B = [1, 5, 6, 5, 4, 3, 3, 1]
 * 
 * Trạng thái bài toán:
 * Tổng giá trị lớn nhất của vali nếu khối lượng không vượt quá i ( i <= W)
 * 
 * Liên hệ giữa các trạng thái:
 * Nhận xét: giá trị của vali phụ thuộc vào 2 yếu tố: có bao nhiêu vật đang được xét và trọng lượng của các vật 
 * ==> Phương án lưu trữ cho các trạng thái của bài này là mảng 2 chiều
 * 
 * Gọi L[i][j] là tổng giá trị lớn nhất của vali khi xét từ vật 1 đến vật i và trọng
 * lượng của vali chưa vượt quá j
 * 
 * Khi xét đến vật i, có 2 trường hợp xảy ra:
 * Nếu lấy vật i ==> L[i][j] = L[i - 1][j - A[i]] + B[i] -> vì nếu muốn lấy vật i, 
 * bwast buộc khối lượng trước đó ko đc vượt quá j - A[i]
 * 
 * Nếu không lấy vật i ==> L[i][j] = L[i - 1][j] (vì chỉ việc bỏ qua vật i)
 * Mà L[i][j] là tổng giá trị lớn nhất
 * ==> L[i][j] = max(L[i-1][j-A[i]] + B[i], L[i-1][j])
 * 
 * Xác định kết quả bài toán:
 * L[n][W]
 */public class knapsack {

    public static void main(String[] args) {
        int W = 20;
        int[] a = new int[]{1, 7, 6, 4, 5, 2, 3, 9};
        int[] b = new int[]{1, 5, 6, 5, 4, 3, 3, 1};
        System.out.println(knapsack(W, a, b));
    }

    public static int knapsack(int W, int[] a, int[] b) {
        int[][] L = new int[a.length + 1][W + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (a[i - 1] <= j) {
                    L[i][j] = L[i - 1][j - a[i - 1]] + b[i - 1];
                } else {
                    L[i][j] = L[i - 1][j];
                }
            }
        }
        return L[a.length][W];
    }
}

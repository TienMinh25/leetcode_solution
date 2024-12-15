/**
 * Cho một tập hợp n loại đồng xu với các mệnh giá coins[]. Bạn cần tìm
 * số lượng đồng xu ít nhất để tổng giá trị bằng S. Bạn có thể sử dụng một mệnh giá đồng xu nhiều lần
 * Nếu không thể tạo được tổng S, hãy trả về -1
 * 
 * Solution: Ta sẽ sử dụng dynamic programming (theo hướng bottom up) để xử lý bài toán này
 * 
 * B1: Xác định trạng thái bài toán
 * Trạng thái bài toán là số lượng đồng xu ít nhất sao cho tổng giá trị bằng S
 * -> Phát biểu lại trạng thái bài toán dưới dạng bài toán con
 * Số lượng đồng xu ít nhất sao cho tổng giá trị bằng i (i <= S)
 * Để tìm ra trạng thái i thì ta cần tìm tất cả trạng thái j trước đó (với j < i) (tức là tính toán
 * bài toán lớn dựa trên các bài toán nhỏ đã tính trước đó)
 * 
 * B2: Tìm mối liên hệ giữa các trạng thái (ở đây là tìm công thức)
 * Với mỗi j, Vj <= i, tìm số đồng xu nhỏ nhất sao cho tổng bằng i - Vj, giả sử nó bằng m.
 * Nếu m + 1 < số đồng xu hiện tại cho tổng i, ta sẽ cập nhật nó bằng m + 1.
 * 
 * Ta có công thức sau: f(i) = k
 * với i là giá trị cần đạt được
 * k là số xu nhỏ nhất
 * 
 * Lấy ví dụ để tìm ra công thức liên hệ giữa các trạng thái:
 * Cho các đồng xu với giá tiền 1, 3 và 5
 * Và S = 11
 * 
 * f(0) = 0 --> Vì ko cần đồng xu nào để đạt được giá trị 0
 * f(1):
 *  Xét các đồng xu, ta thấy Vj chỉ có thể là đồng xu 1
 *  => f(1) = f(1 - V0) + 1 = f(0) + 1 = 0 + 1 = 1 -> (dựa trên việc đưa ra giả thiết ở đầu và
 *  trạng thái f(0))
 * 
 * f(2):
 *  Ta thấy Vj chỉ có thể nhận là đồng xu có giá trị 1
 *  => f(2) = f(2 - V0) + 1 = f(2 - 1) + 1 = f(1) + 1 = 1 + 1 = 2
 * 
 * f(3):
 *  Ta thấy Vj lúc này có thể nhận là đồng xu có giá trị 3 và 1
 * Với giá trị đồng xu là 1:
 *  => f(3) = f(3 - V0) + 1 = f(3 - 1) + 1 = f(2) + 1 = 3
 * Với giá trị đồng xu là 3:
 *  => f(3) = f(3 - V1) + 1 = f(3 - 3) + 1 = f(0) + 1 = 1
 * 
 * Muốn lấy số xu nhỏ nhất ==> f(3) = 1
 * Làm tương tự đối với các trạng thái tiếp theo
 * 
 * Lúc này ta rút ra được công thức cho f(i) = min(f(i), f(i-Vj) + 1);
 * (với i từ 1 đến S)
 * (với j từ 0 đến n - 1)
 * 
 * ==> công thức truy hồi như sau:
 * {
 *    f(0) = 0
 *    f(i) = min(f(i), f(i - Vj) + 1)  (1 <= i <= S, 0 <= j <= n - 1)
 * }
 */
#include<iostream>

using namespace std;

int main() {
  int n, S;
  cin >> S >> n;

  int coins[n], f[S + 1];

  for (int i = 0; i < n; i++) {
    cin >> coins[i];
  }

  for (int i = 0; i <= S; i++) {
    f[i] = INT_MAX;
  }

  f[0] = 0;

  for (int i = 1; i <= S; i++) {
    for (int j = 0; j < n; j++) {
      if (coins[j] <= i && f[i - coins[j]] + 1 < f[i]) {
        f[i] = f[i - coins[j]] + 1;
      }
    }
  }

  cout << "So dong xu nho nhat la: " << f[S] << " cho tong gia tri: " << S << endl;

  return 0;
}
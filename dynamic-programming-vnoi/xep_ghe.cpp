/**
 * Bạn An có n chiếc ghế màu trắng, n chiếc ghế màu đen và n chiếc ghế màu đỏ. An muốn chọn
 * ra n chiếc ghế để xếp thành một hàng ngang. Do An không thích màu đỏ nên An không muốn
 * sắp xếp hai chiếc ghế màu đỏ cạnh nhau. Tính số cách sắp xếp ghế thoả mãn điều kiện đó.
 * Điều kiện: 1 <= n <= 10^5
 * 
 * Bài toán này giải quyết bằng dynamic programming
 * 
 * B1: Xác định trạng thái bài toán
 * Trạng thái bài toán là số cách sắp xếp n ghế thoả mãn điều kiện không có bất kì 2 chiếc ghế đỏ nào
 * được sắp cạnh nhau.
 * 
 * --> Phát biểu lại bài toán dưới dạng bài toán nhỏ hơn:
 * Số cách sắp xếp i ghế thoả mãn điều kiện không có bất kì 2 chiếc ghế đỏ nào được đặt cạnh nhau 
 * (với i <= n)
 * 
 * B2: Tìm mối quan hệ giữa các trạng thái (tìm công thức truy hồi)
 * 
 * Ta có công thức f(i) = k
 * với i là số ghế cần sắp xếp sao cho thoả mãn điều kiện cho trước
 * k là số cách sắp xếp với i ghế đó
 * 
 * Nếu i = 0 ==> f(0) = 0
 * Nếu i = 1 ==> f(1) = 3
 * Nếu i = 2 ==> f(2) = 8
 * 
 * Xét f(n):
 * Nếu chiếc ghế thứ n là trắng hoặc đỏ, thì ghế n-1 có thể là 1 trong 3 màu
 * ==> Có 2 cách sắp xếp và f(n-1) cách sắp xếp cho các ghế còn lại --> 2*f(n-1)
 * 
 * Nếu chiếc ghế thứ n là màu đỏ ==> ghế n - 1 chỉ có thể là ghế trắng hoặc đen và f(n-2) cách sắp xếp còn lại
 * cho các ghế còn lại ==> 1*2*f(n-2)
 * 
 * ==> Công thức truy hồi:
 * f(n) = 2*f(n-1) + 2*f(n-2)
 */

#include<iostream>

using namespace std;

int main() {
  int n;
  cin >> n;

  int f[n + 1];

  f[0] = 0;
  f[1] = 3;
  f[2] = 8;

  for (int i = 3; i <= n; i++) {
    f[i] = 2 * f[i-1] + 2 * f[i-2];
  }

  cout << "Số cách sắp xếp " << n << " chiếc ghế thoả mãn điều kiện là: " << f[n] << "\n";

  return 0;
}
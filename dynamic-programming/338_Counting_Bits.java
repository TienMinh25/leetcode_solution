/**
B1: Tìm trạng thái bài toán
Trạng thái bài toán là số bit 1 khi xét ở số thứ i
B2: Liên hệ giữa các trạng thái
Gọi hàm f(i) là số bit 1 khi xét đến số thứ i

Ta xét ví dụ như này
+ one bit group
 0=   0(0)
 1=   1(1)
+ two bits group
 2=  10(1) = 10(higest bit) + 0
 3=  11(2) = 10 + 1
+ three bits group
 4= 100(1) = 100(higest bit) + 0
 5= 101(2) = 100 + 1
 6= 110(2) = 100 + 2
 7= 111(3) = 100 + 3
+ four bits group
 8=1000(1)=1000(higest bit) + 0
 9=1001(2) = 1000 + 1
10=1010(2) = 1000 + 2
11=1011(3) = 1000 + 3
12=1100(2) = 1000 + 4
13=1101(3) = 1000 + 5
14=1110(3) = 1000 + 6
15=1111(4) = 1000 + 7
+ five bits group
16=10000(1)
...and so on

Ta thấy ở đây, ta đang chia group theo các 2^i với sẽ chạy được từ i cho đến (n+1) >= 2^i
- Tính 2 thứ: 
+ 1 là mũ mà 2 có thể đạt được nhiều nhất
+ 2 là công thức sao cho tính dp okela nhất
dp[j] = dp[2^i] + dp[j - 2^i]
với 2^i là đầu mỗi 2^i, ở đây là 0, 2, 4, 8, 16, 32,.. đó
*/
class Solution {
  public int[] countBits(int n) {
      int[] result = new int[n + 1];
      result[0] = 0;
      result[1] = 1;
      int k = 0;

      for (int i = 2; i <= n; i++) {
        
      }


      return result;
  }
}
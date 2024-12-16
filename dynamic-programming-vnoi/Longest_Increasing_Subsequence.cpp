/*
   Problem: Longest Increasing Subsequence (LIS)
   --------------------------------------------
   Given an integer array nums, return the length of the longest strictly increasing subsequence.

   A subsequence is a sequence that can be derived from an array by deleting some or no elements
   without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence
   of the array [0,3,1,6,2,2,7].

   Input:
   - nums: an array of integers, 1 <= nums.length <= 1000, 1 <= nums[i] <= 10^9

   Output:
   - An integer representing the length of the longest strictly increasing subsequence.

   Example 1:
   Input: nums = [10,9,2,5,3,7,101,18]
   Output: 4
   Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

   Example 2:
   Input: nums = [0,1,0,3,2,3]
   Output: 4

   Example 3:
   Input: nums = [7,7,7,7,7,7,7]
   Output: 1
*/
/**
 * Solution: sử dụng dynamic programming để giải quyết bài toán
 * 
 * B1: Xác định trạng thái bài toán
 * Trạng thái bài toán là độ dài dãy con không giảm dài nhất của dãy a (kết thúc tại a[n])
 * 
 * ==> Phát biểu lại bài toán dưới dạng bài toán con
 * Tìm dãy con không giảm dài nhất kết thúc ở a[i]
 * 
 * B2: Tìm mối liên hệ giữa các trạng thái (tìm công thức truy hồi)
 * Ta đặt f[i] là độ dài dãy con không giảm dài nhất kết thúc tại a[i]
 * 
 * Ta thấy: với mỗi a[i] bất kì, thì độ dài nhỏ nhất của dãy đều là 1
 * Với mỗi j < i, mà a[j] <= a[i] ==> có thể thêm a[i] vào dãy hiện tại ==> f[i] = max(f[i], f[j] + 1)
 * 
 * Ở đây có thể tưởng tượng rằng đến thằng phần tử thứ i, nó không cần quan tâm trước đó có bao nhiêu phần
 * tử đứng trước thoả mãn dãy hay không, mà chỉ cần quan tâm đến phần tử đang xét ở j trước nó là được
 * 
 * Bởi vì kết quả thoả mãn cho đến j đã đc tính toán và lưu trữ ở bài toán nhỏ hơn (đó chính là j)
 * Có thể thấy nó cũng gần giống như Kadane algorithm =)) bởi vì Kadane algorithm cx là thuật toán
 * dp
 * 
*/
#include <iostream>

using namespace std;

int main()
{
  int n; cin >> n;

  int f[n], a[n];

  for (int i = 0; i < n; i++)
    cin >> a[i];

  for (int i = 0; i < n; i++) 
    f[i] = 1;

  for (int i = 1; i < n; i++) {
    for (int j = 0; j < i; j++) {
      if (a[j] <= a[i]) {
        f[i] = max(f[i], f[j] + 1);
      }
    }
  }

  int result = f[0];
  for (int i = 1; i < n; i++) {
    result = max(result, f[i]);
  }

  cout << "Result is: " << result;

  return 0;
}
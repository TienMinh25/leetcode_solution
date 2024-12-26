/**
Bài toán: Tìm dãy con liên tiếp có tổng lớn nhất (trả ra tổng của nó)

Phân tích bài toán:
ở mỗi dãy con thì cần tìm ra tổng lớn nhất?

Solution 1: sử dụng dynamic programming

B1: Xác định trạng thái bài toán
Trạng thái bài toán là tổng lớn nhất của dãy con kết thúc tại ai
Gọi dp[i] là tổng lớn nhất của dãy con kết thúc tại ai

B2: Liên hệ trạng thái
Quyết định có lấy a[i - 1] vào dãy con kết thúc tại a[i] không?
Tại sao lại chỉ xét a[i-1] chứ không xét toàn bộ?

Vì mảng con này cần phải liên tiếp --> vậy nên chỉ cần xem phần tử trước đó có thể lấy vào được mảng
đang xét không?

Ta thấy rằng:
Nếu dp[i - 1] + dp[i] > dp[i] thì lấy
Nếu không thì không lấy
--> Bởi vì nếu lấy, ta mong muốn tổng sẽ lớn hơn chứ không bé đi
Hơn nữa ở mỗi bước trước đó, các bài toán con có i nhỏ hơn đã được tối ưu

-2 1 -3 4 -1 2 1 -5 4
dp:
-2 1 

B3: Xác định kết quả

Solution 2: Sử dụng kadane's algorithm
Phân tích
[5, 4, -1, 7, 8]

- Đối với mỗi vị trí i, ta coi i - 1 phần tử trước đó là 1 phần tử (bằng tổng của các phần tử đó)
Vậy thì ở đây sẽ có 2 lựa chọn (có thêm i vào dãy con đang xét hay không?) -> có hoặc ko
Vậy nếu thêm thì khi nào thêm? -> thêm khi mà currSum + nums[i] > nums[i] thì thêm -> vì như này
thì sum hiện tại sẽ tăng lên thì oke hơn

Nếu currSum + nums[i] < nums[i] thì cập nnhajat currSum = nums[i], vì nếu tổng trước đó đang âm,
nums[i] là số dương thì thêm 1 số âm vào dãy con cần có tổng lớn nhất để làm gì?

==> currSum = max(currSum + nums[i], nums[i]);
*/
class Solution {
  public int maxSubArray(int[] nums) {
      // Kadane's algorithm
      /*
      int currSum = nums[0];
      int maxSum = nums[0];

      for (int i = 1; i < nums.length; i++) {
          currSum = Math.max(currSum + nums[i], nums[i]);
          maxSum = Math.max(maxSum, currSum);
      }

      return maxSum;
      */

      // dynamic programming
      int[] dp = new int[nums.length];

      for (int i = 0; i < nums.length; i++)
          dp[i] = nums[i];

      for (int i = 1; i < nums.length; i++)
          dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
      
      var result = Integer.MIN_VALUE;

      for (var x : dp)
          result = Math.max(x, result);

      return result;
  }
}
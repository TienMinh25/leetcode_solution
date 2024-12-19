/**
 * Solution: bài toán này, để ý phân tích thì có thể thấy, vì là lấy tổng min
 * của các cặp
 * ==> Phải làm thế nào để mỗi min của mỗi cặp là lớn nhất có thể
 * ==> Sort lại mảng, sau đó cứ 2 phần tử một chỉ việc pair với nhau ==> lúc này
 * thì phần tử giá trị lớn nhất có thể
 * của min pair sẽ luôn được lấy ra ==> tổng là max
 */
class Solution {
  // bài toán có nghĩa là cho 2n phần tử, hãy ghép đôi các phần tử này lại
  // sao cho sum các min của các cặp là maximized
  public int arrayPairSum(int[] nums) {
      int n = nums.length;

      Arrays.sort(nums);

      int result = 0;

      for (int i = 0; i < n; i += 2) {
          result += Math.min(nums[i], nums[i + 1]);
      }

      return result;
  }
}
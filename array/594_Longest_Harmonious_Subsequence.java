/**
 * - Nhận thấy rằng việc để đáp ứng được 1 mảng với min value và max value là 1
 * ==> mảng đó chỉ chứa những phần tử
 * có giá trị cách nhau lớn nhất == 1
 * - Nhận thấy rằng việc rerange mảng cũng không ảnh hưởng ==>
 * Solution 1: sử dụng sorting ==> sort xong chỉ việc tìm được mảng con nào có
 * độ dài dài nhất cho thỏa mãn bài toán, sử dụng thêm sliding window technique
 * Solution 2: sử dụng couting (dùng map hoặc array ở đây) đều oke, với việc chỉ
 * cần duyệt lại qua mảng couting dể tìm ra độ dài mảng dài nhất
 */
class Solution {
  public int findLHS(int[] nums) {
      // Solution 2:
      /*
      int result = 0;
      Map<Integer, Integer> numMap = new HashMap<>();

      for (var num : nums) {
          numMap.put(num, numMap.getOrDefault(num, 0) + 1);
      }

      for (var num : nums) {
          if (numMap.containsKey(num) && numMap.containsKey(num + 1)) {
              result = Math.max(result, numMap.get(num) + numMap.get(num + 1));
          }
      }

      return result;
      */

      // Solution 1:
      int result = 0;

      Arrays.sort(nums);

      int diff, left = 0, right = 1;

      while (right < nums.length) {
          diff = Math.abs(nums[left] - nums[right]);

          if (diff == 1) {
              result = Math.max(result, right - left + 1);
              right++;
          } else if (diff < 1) {
              right++;
          } else {
              left++;
          }
      }

      return result;
  }
}
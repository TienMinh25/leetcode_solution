/*
- solution 1: duyệt qua mảng, so sánh phần tử ở vị trí k, với k bắt đầu từ index 1
Nếu gặp đc phần tử khác -> chỉ việc set lại giá trị cần so sánh và tăng k --> O(n)
- solution 2: có thể sử dụng set để check việc phần tử trùng, kết hợp với vòng lặp for để 
vừa duyệt vừa set
*/
class Solution {
  public int removeDuplicates(int[] nums) {
      // Solution 1:
      /*
      int k = 1;
      int elementCompare = nums[0];
      int n = nums.length;

      for (int i = 1; i < n; i++) {
          if (nums[i] != elementCompare) {
              nums[k] = nums[i];
              elementCompare = nums[i];
              k++;
          }
      }

      return k;
       */
      
      // Solution 2:
      Set<Integer> numSet = new HashSet<>();

      var index = 0;

      for (var x : nums) {
          if (!numSet.contains(x)) {
          nums[index] = x;
          numSet.add(x);
          index++;
          }
      }

      return index;
  }
}
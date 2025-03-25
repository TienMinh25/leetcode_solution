class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> res = new ArrayList<>();

      if (nums.length < 4) {
          return res;
      }
      int n = nums.length;
      Arrays.sort(nums);

      for (int i = 0; i < n - 3; i++) {
          // co case nay vi neu da co i truoc do thoa man hoac khong thoa man, thi hoan toan 
          // da thu het toan bo case roi
          if (i > 0 && nums[i] == nums[i - 1]) {
              continue;
          }
          
          for (int j = i + 1; j < n - 2; j++) {
              if (j > i + 1 && nums[j] == nums[j - 1]) {
                  continue;
              }

              int left = j + 1;
              int right = n - 1;

              while (left < right) {
                  long current_sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
              
                  if (current_sum == target) {
                      res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                      left++;

                      while (left < right && nums[left - 1] == nums[left]) {
                          left++;
                      }

                      continue;
                  }

                  if (current_sum < target) {
                      left++;
                  } else {
                      right--;
                  }
              }
          }
      }

      return res;
  }
}
// y tuong: giu 2 phan tu, con 2 phan tu cho chay de tim 

/** dau tien can sort de co the biet lam cach nao di chuyen 2 phan tu kia nhu two pointer
-2 -1 0 0 1 2
gio ma giu i va j la 2 con, sau do cho chay 2 con left, right


Phân tích yêu cầu đề bài: có 3 thứ:
- a, b, c, d < n (số lượng phần tử) -> tức là nếu đã được sắp xếp mà phần tử cuối cùng (tức index right) mà < n
==> các phần tử trước đó cx bé hơn -> thoả mãn điều kiện 1

- tổng 4 số == target
-> sau khi thoả mãn điều kiện 1, tiến hành tính curent_sum để check bằng target hay ko
thế ko bằng thì skip rồi,
nhưng nếu bằng thì tăng left hay right -> chọn tăng left
thế chọn tăng left, thì chọn như nào để nó ko bị duplicate?
tức là nếu sau tăng left mà nums[left - 1] == nums[left] thì skip qua tiếp -> vì biết rằng nếu bằng thì kiểu gì chả ra cùng 1 tập thoả mãn nữa

- cái tập 4 số thoả mãn là unique
*/
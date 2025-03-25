// solution: tham khảo nittcode -> sort trước, sau đó cố định 1 con i, cho 2 con trỏ j và k chạy
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);

      List<List<Integer>> res = new ArrayList<>();

      for (int i = 0; i < nums.length; i++) {
          // skip case duplicate, vì chắc chắn nếu có cùng phần tử i trước đó, thì các case thoả mãn đã có rồi
          if (i > 0 && nums[i] == nums[i - 1]) {
              continue;
          }
          
          int j = i + 1;
          int k = nums.length - 1;

          while (j < k) {
              int total = nums[i] + nums[j] + nums[k];

              if (total > 0) {
                  k--;
              } else if (total < 0) {
                  j++;
              } else {
                  res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                  j++;

                  // skip phần tử j vì biết khi tăng j mà nums[j] và nums[j-1] vẫn bằng nhau thì chắc
                  // chắn sẽ bị trùng về bộ ba số thoả mãn điều kiện
                  while (j < k && nums[j] == nums[j - 1]) {
                      j++;
                  }
              }
          }
      }

      return res;
  }
}
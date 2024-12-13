/*
- Solution 1: duyệt qua mảng, phần tử nào mà bằng thì chỉ việc skip qua, việc index sẽ do mình ghi lại,
nghĩa là có 1 biến index để track, trong lúc đó chỉ việc duyệt tiếp các phần tử trong mảng gốc là okela
space complexity: O(1)
time complexity: O(n)

- Solution 2: sử dụng HashMap để lưu trữ lại value nào khác val thì được đưa vào HashMap, sau đó
ta chỉ việc set lại array là được, cũng cần keep track index để đưa ra câu trả lời
space complexity: O(2n)
time complexity: O(n)
*/
class Solution {
  public int removeElement(int[] nums, int val) {
    // solution 1:
    int keepTrackIndex = 0;

    for (var x : nums) {
        if (x != val) {
            nums[keepTrackIndex] = x;
            keepTrackIndex++;
        }
    }

    return keepTrackIndex;

    // Solution 2:
    /* 
    Map<Integer, Integer> numMap = new HashMap<>();

    int k = 0;

    for (var x : nums) {
      if (x != val) {
        nums[k] = x;
        k++;
        numMap.put(k, x);
      }
    }

    return numMap.size();
    */
  }
}
/**
 * Solution 1: two pointer
 * Solution 2: dynamic programming
 Với bài toán này, ta sẽ preprocess trước String t gốc, vì làm vậy, nếu đầu vào nhiều string cần kiểm tra,
 thì các string cần kiểm tra đó chỉ cần so khớp với preprocess đã làm với string t ==> độ phức tạp sẽ là tuyến tính

 B1: Xác định trạng thái bài toán
 Trạng thái bài toán là 
 */
class Solution {
  public boolean isSubsequence(String s, String t) {
      int i = 0, j = 0;

      while (i < s.length() && j < t.length()) {
          if (s.charAt(i) == t.charAt(j)) {
              i++;
          }
          
          j++;
      }

      return i == s.length();
  }
}
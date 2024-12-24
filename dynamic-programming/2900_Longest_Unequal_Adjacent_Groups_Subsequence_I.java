
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Phân tích bài toán: n = words.length = groups.length tìm longest subsequence
 * cho groups với các phần tử bit 0 và 1 xen kẽ ==> tìm cái dài nhất Solution:
 * using dynamic programming B1: Xác định trạng thái bài toán Trạng thái bài
 * toán là độ dài lớn nhất của subsequence khi xét đến vị trí thứ i (index)
 * trong groups
 *
 * B2: Liên hệ giữa các trạng thái Ta thấy, mỗi bit trong groups đều là 1
 * subsequence ==> dp[i] = 1 (0 <= i < n)
 * Gọi hàm dp[i] là độ dài lớn nhất của subsequence khi xét đến vị trí thứ i
 * Ở đây tại mỗi bước, mình có chọn bit đó không là dựa vào đâu? -> dựa vào bit
 * trước đó đã chọn
 *
 * VD: groups: 0 0 1 1 0 1 0 1 1 0 kết quả: 0 1 0 1 0 1 0 -> 7
 */
class Solution {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        // greedy algorithm
        List<Integer> tmp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        tmp.add(0);
        int selected = groups[0];

        for (int i = 1; i < groups.length; i++) {
          if (groups[i] != selected) {
            tmp.add(i);
            selected = groups[i];
          }
        }

        for (var index : tmp) {
          result.add(words[index]);
        }

        return result;
    }
}

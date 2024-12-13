/*
cho 1 mảng số nguyên nums và 1 số target (integer)
--> trả về chỉ số của 2 số trong mảng mà cộng chúng lại thì bằng target
- solution 1: dùng 2 vòng lặp rồi thử từng số cộng với nhau bằng target không, nếu có thì in ra
O(n^2) --> oke vì là O(10^8)
space complexity: O(1)

- solution 2: 2 7 11 15
sắp xếp rồi dùng two pointer --> okela? --> độ phức tạp: O(nlogn)
--> ko dùng được do đã reindex  

- solution 3: dùng hashmap để lưu trữ value làm key --> index làm value của hash map
sau đó duyệt qua mảng để trừ, nếu có trong hashmap thì oke --> bỏ vào hoi

ở đây dù trùng value rồi ghi đè index cx đc --> vì bài toán có cho đáp án đúng là đc.
time complexity: O(n)
space complexity: O(n)

- solution 4: sắp xếp rồi dùng binary search để tìm ra được phần tử có vị trí có value đó là okela :D
--> cũng không được do đã thay đổi vị trí phần tử mất rồi
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Solution 1:
        /*
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
         */
        
        // Solution 3:
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int numberFind = target - nums[i];

            if (numMap.containsKey(numberFind)) {
                return new int[]{i, numMap.get(numberFind)};
            }

            numMap.put(nums[i], i);
        }
        
        return new int[]{};
    }
}
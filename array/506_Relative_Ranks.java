/**
 * - Solution: sử dụng HashTree --> vừa sort được theo điểm, vừa lưu lại được
 * index
 * ==> Từ index get ra thì chỉ việc set lại dần là xong
 * Time complexity: O(nlogn)
 * Space complexity: O(2*n)
 */
class Solution {

    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];

        // <score, index>
        TreeMap<Integer, Integer> scoreMap = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < score.length; i++) {
            scoreMap.put(score[i], i);
        }

        int k = 1;

        for (var key : scoreMap.keySet()) {
            if (k == 1) {
                result[scoreMap.get(key)] = "Gold Medal";
                k++;
            } else if (k == 2) {
                result[scoreMap.get(key)] = "Silver Medal";
                k++;
            } else if (k == 3) {
                result[scoreMap.get(key)] = "Bronze Medal";
                k++;
            } else {
                result[scoreMap.get(key)] = String.valueOf(k++);
            }
        }

        return result;
    }
}

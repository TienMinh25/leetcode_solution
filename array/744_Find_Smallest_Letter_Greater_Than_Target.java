
class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        int[] asciiLetter = new int[letters.length];
        int targetAscii = (int) target;

        for (int i = 0; i < letters.length; i++) {
            asciiLetter[i] = (int) letters[i];
        }

        int charIdx = upper_bound(asciiLetter, targetAscii);

        return charIdx != letters.length ? letters[charIdx] : letters[0];
    }

    public int upper_bound(int[] arr, int indexSearch) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (arr[mid] <= indexSearch) {
                low = mid + 1; 
            }else {
                high = mid - 1;
            }
        }

        return low;
    }
}
/* size = 8
 * 1 4 6 8 9 10 12 20
 * target = 10
 * low = 0, high = 7
 * -> mid: 3 -> arr[mid] = 8 < 10
 * ==> low = mid + 1 = 3 + 1 = 4, high = 7
 * -> mid: 11/2 = 5 -> arr[mid] = 10 = target --> low = mid + 1 = 5 + 1 = 6
 * -> mid: 13/2 = 6 -> arr[mid] = 12 > target -> high = 7 - 1 = 6
 */

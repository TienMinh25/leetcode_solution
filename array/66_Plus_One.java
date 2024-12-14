/**
 * Problem: Increment the integer represented by an array of digits by one.
 * Each element in the array represents a single digit, and the array does not contain leading zeros.
 * 
 * Solution:
 * - Start from the least significant digit (rightmost digit) and add one.
 * - Handle the carry-over if the digit becomes 10.
 * - If a carry-over remains after processing all digits, prepend a new digit (1) at the start of the array.
 * 
 * Time Complexity: O(n), where n is the number of digits.
 * Space Complexity: O(n), due to the potential creation of a new array if there is an overflow.
 */
class Solution {
  public int[] plusOne(int[] digits) {
      int n = digits.length;

      for (int i = n - 1; i >= 0; i--) {
          if (digits[i] < 9) {
              digits[i]++;
              return digits;
          }

          digits[i] = 0;
      }

      var result = new int[n + 1];
      result[0] = 1;

      return result;
  }
}
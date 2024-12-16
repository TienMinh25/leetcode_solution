
import java.util.HashMap;
import java.util.Map;

/*
 * Solution 1: Using a HashMap to count occurrences of each element.
 * The idea is to count how many times each number appears in the array using a HashMap.
 * Then, iterate through the map to find the number that appears more than n / 2 times.
 * 
 * Solution 2: Boyer-Moore Voting Algorithm
 * The Boyer-Moore Voting Algorithm is an efficient way to find the majority element.
 * The idea is to maintain a candidate element and a counter. If the counter is zero, we select the current element as the candidate.
 * Then, if the current element is the same as the candidate, increment the counter; otherwise, decrement it.
 * By the end of the loop, the candidate will be the majority element.
 */

 class Solution {
  public int majorityElement(int[] nums) {
      // Solution 1: Using HashMap (commented out for now)
      /*
      int n = nums.length;
      int result = 0;
      Map<Integer, Integer> numMap = new HashMap<>();

      // Count occurrences of each number using the HashMap
      for (var x : nums) {
          if (numMap.containsKey(x)) {
              numMap.put(x, numMap.get(x) + 1);
          } else {
              numMap.put(x, 1);
          }
      }

      // Iterate over the map to find the majority element (appears more than n / 2 times)
      for (var key : numMap.keySet()) {
          if (numMap.get(key) > (n / 2)) {
              result = key;
              break;
          }
      }

      return result;
      */

      // Solution 2: Boyer-Moore Voting Algorithm (used here)
      int candidate = 0, count = 0;

      // Iterate through the array to find the majority element
      for (var x : nums) {
          // If the counter is zero, select the current number as the new candidate
          if (count == 0) {
              candidate = x;
          }

          // If the current number is the same as the candidate, increment the count
          // Otherwise, decrement the count
          if (candidate == x)
              count++;
          else
              count--;
      }
      
      // After the loop, 'candidate' will hold the majority element
      return candidate;
  }
}
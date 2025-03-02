/**
Phan tich bai toan 
Solution
Coding
*/
class Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
      // 26 ki tu
      int[] countChar = new int[26];
      int idxRes = -1;

      // O(n)
      for (var ch : licensePlate.toCharArray()) {
          // letter
          if (Character.isAlphabetic(ch)) {
              var chLowerCase = Character.toLowerCase(ch);
              countChar[chLowerCase - 'a']++;
          }
      }

      // handle case words
      for (int i = 0; i < words.length; i++) {
          boolean flag = true;
          int[] wordCountChar = new int[26];

          for (var ch : words[i].toCharArray()) {
              if (Character.isAlphabetic(ch)) {
                  var wordCountCharLower = Character.toLowerCase(ch);
                  wordCountChar[wordCountCharLower - 'a']++;
              }
          }

          for (int m = 0; m < 26; m++) {
              if (countChar[m] > wordCountChar[m]) {
                  flag = false;
                  break;
              }
          }

          // word satisfy condition
          if (flag) {
              if (idxRes == -1) {
                  idxRes = i;
                  continue;
              }

              if (words[idxRes].length() > words[i].length()) {
                  idxRes = i;
              }
          }
      }

      return words[idxRes];
  }
}

// Space complexity: O(26)
// time complexity: O(m^2) -> 1000^2 = 1tr6
// 2*10^8

/**
a - z
precomputing
licensePlate = "1s3 PSt" -> letters -> 
hash -> (key, value) -> key -> character letter, value -> number of sequence

a A -> true

input:
  licensePlate -> lowercase letters
  array of words

condition:
  - word in words: number of sequence appear in word >= number of sequence appear in licensePlate
  - Return shortest string satisfy given condition
  - Return first one that occurs in words

output:
  
*/
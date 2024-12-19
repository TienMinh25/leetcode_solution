class Solution {
  public String[] findWords(String[] words) {
      String firstRow = "qwertyuiop";
      String secondRow = "asdfghjkl";
      String thirdRow = "zxcvbnm";

      int[] a = new int[26];

      for (int i = 0; i < firstRow.length(); i++) {
          a[(int) firstRow.charAt(i) - (int) 'a'] = 0;
      }

      for (int i = 0; i < secondRow.length(); i++) {
          a[(int) secondRow.charAt(i) - (int) 'a'] = 1;
      }

      for (int i = 0; i < thirdRow.length(); i++) {
          a[(int) thirdRow.charAt(i) - (int) 'a'] = 2;
      }

      String[] tmp = new String[100];
      int idx = 0;

      for (var word : words) {
          int flag1 = 0, flag2 = 0, flag3 = 0;
          String lowercaseWord = word.toLowerCase();

          for (int i = 0; i < lowercaseWord.length(); i++) {
              switch (a[(int) lowercaseWord.charAt(i) - (int) 'a']) {
                  case 0: {
                      flag1 = 1;
                      break;
                  }
                  case 1: {
                      flag2 = 1;
                      break;
                  }
                  case 2: {
                      flag3 = 1;
                  }
              }

              if (flag1 + flag2 + flag3 > 1) {
                  break;
              }
          }

          if (flag1 + flag2 + flag3 > 1) {
              continue;
          }

          tmp[idx++] = word;
      }

      return Arrays.copyOf(tmp, idx);
  }
}
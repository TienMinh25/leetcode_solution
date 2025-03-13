class Solution {
  public int[] shortestToChar(String s, char c) {
      var chArray = s.toCharArray();
      var result = new int[s.length()];
      for (int idx = 0; idx < chArray.length; idx++) {
          if (chArray[idx] == c) {
              result[idx] = 0;
              continue;
          }
          
          int leftIdx = -1, rightIdx = -1;
          // find left
          for (int fromLeft = idx - 1; fromLeft >= 0; fromLeft--) {
              if (chArray[fromLeft] == c) {
                  leftIdx = fromLeft;
                  break;
              }
          }

          // find right
          for (int fromRight = idx + 1; fromRight < chArray.length; fromRight++) {
              if (chArray[fromRight] == c) {
                  rightIdx = fromRight;
                  break;
              }
          }

          if (leftIdx != -1 && rightIdx != -1) {
              result[idx] = Math.min(idx - leftIdx, rightIdx - idx);
              continue;
          }

          if (leftIdx != -1) {
              result[idx] = idx - leftIdx;
          }

          if (rightIdx != -1) {
              result[idx] = rightIdx - idx;
          }
      }

      return result;
  }   
}

// y tuong, o moi lan duyet cua char array -> tim trai va phai xem cai nao gan hon
// dung brute force
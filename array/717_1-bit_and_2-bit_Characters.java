class Solution {
  public boolean isOneBitCharacter(int[] bits) {
      int i = 0;

      while (i < bits.length) {
          if (i == bits.length - 2 && bits[i] == 1) {
              return false;
          }

          if (bits[i] == 1)
              i += 2;
          else 
              i += 1;
      }

      return true;
  }
}
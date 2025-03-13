class Solution {
  public int[] numberOfLines(int[] widths, String s) {
      var chArrays = s.toCharArray();
      int numberLine = 1;
      int currentPixels = 0;

      for (var ch : chArrays) {
          int idx = ch - 'a';
          if (currentPixels + widths[idx] > 100) {
              currentPixels = widths[idx];
              numberLine++;
              continue;
          } 

          currentPixels += widths[idx];
      }

      return new int[]{numberLine, currentPixels};
  }
}

// each element with corresponding index will have x pixels
// each line is no longer than 100 pixels
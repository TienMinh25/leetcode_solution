class Solution {
  public int[][] flipAndInvertImage(int[][] image) {
      for (int currentRow = 0; currentRow < image.length; currentRow++) {
          int colSize = image[currentRow].length;
          for (int i = colSize - 1; i >= colSize/2; i--) {
              int idxCorres = colSize - 1 - i;

              if (idxCorres == i) {
                  image[currentRow][i] = image[currentRow][i] == 1 ? 0 : 1;
                  continue;
              }

              var tmp = image[currentRow][i];
              image[currentRow][i] = image[currentRow][idxCorres] == 1 ? 0 : 1;
              image[currentRow][idxCorres] = tmp == 1 ? 0 : 1;
          }
      }

      return image;
  }
}
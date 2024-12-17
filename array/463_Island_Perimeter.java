/*
* Solution: The idea is simple. We calculate the total perimeter of all the cells, and then subtract the overlapping edges where two adjacent cells belong to the island. 
* This ensures we don't count the shared borders multiple times.
*/

class Solution {
  public int islandPerimeter(int[][] grid) {
      int rows = grid.length, cols = grid[0].length; // Get the number of rows and columns in the grid
      int islandCells = 0; // To keep track of the number of land cells (cells with value 1)
      int sharedEdges = 0; // To count the number of shared edges between adjacent land cells

      // Traverse the entire grid to identify land cells and shared edges
      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              if (grid[i][j] == 1) { // If the current cell is a land cell
                  islandCells++; // Increment the number of land cells

                  // Check if the cell has an adjacent land cell to the right (horizontal edge)
                  if (j < cols - 1 && grid[i][j + 1] == 1) sharedEdges++;
                  
                  // Check if the cell has an adjacent land cell below (vertical edge)
                  if (i < rows - 1 && grid[i + 1][j] == 1) sharedEdges++;
              }
          }
      }

      // The total perimeter is initially 4 times the number of land cells (each cell has 4 edges).
      // Subtract the shared edges (since they are counted twice) from the perimeter.
      // Each shared edge is counted twice, so we subtract twice the number of shared edges.
      return islandCells * 4 - sharedEdges * 2;
  }
}
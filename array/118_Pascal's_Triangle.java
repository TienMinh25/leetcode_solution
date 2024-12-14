
import java.util.ArrayList;
import java.util.List;

/*
 * Solution: Generate Pascal's Triangle.
 * Approach:
 * - Start with the first row `[1]` and build subsequent rows iteratively.
 * - Each element in a row (except the first and last) is the sum of the two elements 
 *   directly above it in the previous row:
 *   a[i][j] = a[i-1][j-1] + a[i-1][j]
 * - Constraints:
 *   - First and last elements of each row are always `1`.
 *   - The number of elements in the `i-th` row is equal to `i + 1`.
 */
// Example of Pascal's Triangle:
// numRows = 5
// Row 1: [1]
// Row 2: [1, 1]
// Row 3: [1, 2, 1] (a[3][2] = a[2][1] + a[2][2])

class Solution {
  public List<List<Integer>> generate(int numRows) {
      // Initialize the result list
      List<List<Integer>> result = new ArrayList<>();

      // Add the first row `[1]`
      result.add(List.of(1));

      // Handle the base case where only one row is needed
      if (numRows == 1) {
          return result;
      }

      // Add the second row `[1, 1]`
      result.add(List.of(1, 1));

      // Generate rows from the third row onwards
      for (int i = 2; i < numRows; i++) {
          // Start a new row with `1`
          List<Integer> rowList = new ArrayList<>(List.of(1));

          // Fill in the intermediate elements using the formula
          for (int j = 1; j < i; j++) {
              int value = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
              rowList.add(value);
          }

          // End the row with `1`
          rowList.add(1);

          // Add the completed row to the result
          result.add(rowList);
      }

      return result;
  }
}
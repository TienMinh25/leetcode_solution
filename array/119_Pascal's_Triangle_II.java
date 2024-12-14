
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        // Initialize the result list with 1s
        for (int i = 1; i <= rowIndex + 1; i++) {
            result.add(1);
        }

        // Use a nested loop to calculate the values in the row
        for (int i = 2; i < rowIndex + 1; i++) {
            for (int j = 1; j < i; j++) {
                // Update the current element based on the sum of the two adjacent elements
                result.set(i - j, result.get(i - j) + result.get(i - j - 1));
            }
        }

        return result;
    }
}

/*
* for (int i = 2; i < rowIndex + 1; ++i)
* for (int j = 1; j < i; ++j)
* ans[i - j] += ans[i - j - 1];
* 
* 3
* 1 1 1 1
* 1 2 3 1
* a[3-1] = a[2] + a[1]
* a[3-2] = a[1] + a[0] = 3
*/

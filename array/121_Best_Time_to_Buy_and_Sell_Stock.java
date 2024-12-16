/*
 * Solution: This is a variation of Kadane's algorithm.
 * Kadane's algorithm can be applied to the "Best Time to Buy and Sell Stock" problem if we consider "buying" as
 * starting a subarray (starting from a specific day), and "selling" as ending the subarray (on a later day).
 * With this approach, the code looks like this:
 */

 class Solution {
  public int maxProfit(int[] prices) {
      // Initialize 'buy' with the first price in the array
      int buy = prices[0];
      
      // Initialize 'profit' to 0, as initially there's no profit
      int profit = 0;

      // Loop through the prices starting from the second day
      for (int i = 1; i < prices.length; i++) {
          // If the current price is lower than the 'buy' price, update 'buy'
          if (prices[i] < buy) {
              buy = prices[i];
          }
          // If selling today provides a higher profit than the previous profit, update 'profit'
          else if (prices[i] - buy > profit) {
              profit = prices[i] - buy;
          }
      }

      // Return the maximum profit achieved
      return profit;
  }
}
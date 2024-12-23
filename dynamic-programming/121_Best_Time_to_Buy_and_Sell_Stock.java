/*
B1: Tìm trạng thái bài toán:
Trạng thái bài toán là max profit khi xét đến ngày thứ i
f(i) là hàm lợi nhuận max khi đến ngày thứ i
B2: Tìm liên hệ giữa các trạng thái:
Ta nhận thấy: nếu ngày hôm nay bán đi stock ==> sẽ phải so sánh so với ngày i - 1 xem profit nếu
bán ở ngày i - 1 có lớn hơn so với mình bán ở ngày i không
vì cta biết rằng ở i-1 là hàm lợi nhuận max đến ngyaf thứ i-1,
vậy nên ta chỉ việc so sánh nếu bán ở ngày thứ i (prices[i] - minPrice)
minPrice là stock có giá thấp nhất đã mua ở ngày k (k < i)
f(i) = max(f[i-1], prices[i] - minPrice)
*/
class Solution {
  public int maxProfit(int[] prices) {
      // using dynamic programming
      int[] profit = new int[prices.length];
      profit[0] = 0;
      int minPrice = prices[0];

      for (int i = 1; i < prices.length; i++) {
          profit[i] = Math.max(profit[i - 1], prices[i] - minPrice);
          minPrice = Math.min(prices[i], minPrice);
      }

      return profit[prices.length - 1];

      // optimize
  }
}
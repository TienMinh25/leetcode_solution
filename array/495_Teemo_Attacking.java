class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
      int tmp = timeSeries[0] + duration - 1;  // Thời gian hết độc của mũi tên đầu tiên
      int start = timeSeries[0];  // Thời điểm bắt đầu nhiễm độc
      int totalSecondsPoisoned = 0;  // Tổng thời gian nhiễm độc

      // Duyệt qua các mũi tên tiếp theo
      for (int i = 1; i < timeSeries.length; i++) {
          if (timeSeries[i] <= tmp) {  // Nếu mũi tên trúng trong khoảng thời gian nhiễm độc hiện tại
              tmp = timeSeries[i] + duration - 1;  // Kéo dài thời gian nhiễm độc
          } else {
              // Tính tổng thời gian nhiễm độc cho mũi tên trước đó
              totalSecondsPoisoned += (tmp - start + 1);
              start = timeSeries[i];  // Cập nhật thời điểm bắt đầu nhiễm độc
              tmp = timeSeries[i] + duration - 1;  // Cập nhật thời gian hết độc cho mũi tên mới
          }
      }

      // Thêm thời gian nhiễm độc cho mũi tên cuối cùng
      totalSecondsPoisoned += (tmp - start + 1);

      return totalSecondsPoisoned;  // Trả về tổng thời gian nhiễm độc
  }
}
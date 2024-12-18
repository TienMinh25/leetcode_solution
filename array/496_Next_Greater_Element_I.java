class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      // Khởi tạo mảng kết quả với kích thước bằng nums1
      int[] result = new int[nums1.length];

      // solution 1: brute force
      /*
      // Phương pháp brute force: Duyệt từng phần tử trong nums1 và tìm phần tử lớn hơn tiếp theo trong nums2
      for (int i = 0; i < nums1.length; i++) {
          int tmp = -1;  // Biến tạm để lưu phần tử lớn hơn tiếp theo

          // Duyệt mảng nums2 từ cuối đến đầu để tìm phần tử lớn hơn tiếp theo
          for (int j = nums2.length - 1; j >= 0; j--) {
              if (nums2[j] > nums1[i]) {
                  tmp = nums2[j];  // Cập nhật tmp nếu tìm thấy phần tử lớn hơn
              } else if (nums2[j] == nums1[i]) {
                  result[i] = tmp;  // Lưu kết quả và thoát khỏi vòng lặp
                  break;
              }
          }
      }
      */

      // solution 2: using hash map + stack
      // Phương pháp sử dụng HashMap và Stack để tìm phần tử lớn hơn tiếp theo nhanh chóng

      // Khởi tạo một HashMap để lưu vị trí của từng phần tử trong nums2
      Map<Integer, Integer> index = new HashMap<>();

      // Khởi tạo Stack để duy trì các chỉ số của các phần tử trong nums2 sao cho thứ tự của các phần tử trong stack là không giảm
      Stack<Integer> indices = new Stack<>();

      // Khởi tạo một ArrayList để lưu giá trị phần tử lớn hơn tiếp theo của mỗi phần tử trong nums2, mặc định là -1 (nếu không có phần tử lớn hơn)
      ArrayList<Integer> nextGreater = new ArrayList<>(Collections.nCopies(nums2.length, -1));

      // Duyệt qua tất cả các phần tử trong nums2
      for (int i = 0; i < nums2.length; i++) {
          // Kiểm tra phần tử hiện tại có lớn hơn phần tử ở đỉnh stack hay không
          // Nếu có, cập nhật nextGreater cho các phần tử ở đỉnh stack (các phần tử này không còn lớn hơn nums2[i] nữa)
          while (!indices.empty() && nums2[indices.peek()] < nums2[i]) {
              nextGreater.set(indices.pop(), nums2[i]);
          }

          // Đẩy chỉ số của phần tử hiện tại vào stack
          indices.push(i);

          // Lưu chỉ số của phần tử nums2[i] vào HashMap
          index.put(nums2[i], i);
      }

      // Duyệt qua tất cả các phần tử trong nums1
      for (int i = 0; i < nums1.length; i++) {
          // Lấy chỉ số của phần tử nums1[i] từ HashMap
          int j = index.get(nums1[i]);

          // Cập nhật giá trị phần tử lớn hơn tiếp theo từ ArrayList (nextGreater)
          result[i] = nextGreater.get(j);
      }

      // Trả về mảng kết quả
      return result;
  }
}
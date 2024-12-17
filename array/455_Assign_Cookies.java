/*
* Solution 1: sort lại cả 2 mảng g và s ==> lúc này dùng 2 pointer, 1 pointer cho g, 1 pointer cho s
* Nếu pointer cho s không phù hợp so với pointer hiện tại cho g, đơn giản chỉ tăng pointer của g lên 
* Bởi vì nếu miếng cookie có kích thước nhỏ nhất ko làm hài lòng cho đứa trẻ có greed factor thì cần phải tăng thôi =))
* Sorting + two pointer --> greedy algorithm
* time complexity: O(nlogn), space complexity: O(1)
*
* Solution 2: có thể chỉ sort 1 mảng thôi, sau đó dùng binary search đối với mỗi phần tử trong mảng còn lại để xem thỏa mãn bao nhiêu
* là oke -> khó khăn trong việc tránh đưa lại cùng 1 bánh quy cho đứa trẻ --> phải đánh dấu lại
*
* Solution 3: 
*/
class Solution {
  public int findContentChildren(int[] g, int[] s) {
      // Solution 1:
      int numOfChildren = g.length, numOfCookies = s.length;

      if (numOfCookies == 0)
          return 0;
      
      Arrays.sort(g);
      Arrays.sort(s);

      int i = 0, j = 0;
      int result = 0;
      while (i < numOfChildren && j < numOfCookies) {
          if (g[i] > s[j]) {
              j++;
          } else {
              i++; j++;
              result += 1;
          }
      }

      return result;
  }
}
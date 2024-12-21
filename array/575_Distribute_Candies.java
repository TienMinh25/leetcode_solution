/**
 * - Solution 1: sử dụng sorting + 1 biến count để đếm số lượng kiểu kẹo có thể
 * ăn được
 * với max mà count có thể đạt được là candyType.length / 2
 * - Solution 2: sử dụng map (có thể dùng set hoặc array làm index cũng đều
 * được)
 * với bài toán này, vì candyType[i] có thể âm, nếu dùng index array thì ta cần
 * + 10^5
 hoặc dùng array cũng okela, nếu dùng boolean[] đánh dấu cho type kẹo
 * vì vậy ta quyết định dùng set
 */
class Solution {
  public int distributeCandies(int[] candyType) {
      Set<Integer> candyTypeSet = new HashSet<>();
      int maxEat = candyType.length / 2;

      for (var x : candyType) {
          candyTypeSet.add(x);
      }

      return candyTypeSet.size() > maxEat ? maxEat : candyTypeSet.size();
  }
}
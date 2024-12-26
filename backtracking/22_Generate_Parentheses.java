class Solution {
  public List<String> generateParenthesis(int n) {
      List<String> result = new ArrayList<>();

      backtrack(result, "", 0, 0, n);

      return result;
  }

  void backtrack(List<String> result, String current, int open, int close, int max) {
      // base case
      if (open == close && open + close == max * 2) {
          result.add(current);
          return;
      }

      if (open < max) {
          backtrack(result, current + "(", open + 1, close, max);
      }

      if (close < open) {
          backtrack(result, current + ")", open, close + 1, max);
      }
  }
}
class Solution {
  public int fib(int n) {
      int[] f = new int[n + 1];
      f[0] = 0;

      if (n == 0) {
          return f[0];
      }

      for (int i = 1; i <= n; i++) {
          if (i == 1) {
              f[1] = 1;
          } else {
              f[i] = f[i - 1] + f[i - 2];
          }
      }

      return f[n];
  }
}
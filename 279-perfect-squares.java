// Given a positive integer n, find the least number of perfect square numbers
// (for example, 1, 4, 9, 16, ...) which sum to n.

// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
//     return 2 because 13 = 4 + 9.

public class Solution {
  public int numSquares(int n) {
    if (n < 0) return 0;

    int[] counts = new int[n + 1];
    Arrays.fill(counts, Integer.MAX_VALUE);
    counts[0] = 0;

    for (int i=1; i<=n; i++) {
      for (int j=1; j*j<=i; j++) {
        counts[i] = Math.min(counts[i], 1 + counts[i-j*j]);
      }
    }

    return counts[n];
  }
}

// Given a 2D binary matrix filled with 0's and 1's,
// find the largest square containing only 1's and return its area.
//
//
// For example, given the following matrix:
//
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
//
// Return 4.

// https://leetcode.com/problems/maximal-square

// solution1: dp
//      |
//      |
// --------
//      |
// dp[i][j] = matrix[i][j] == 0
// ? 0
// : Math.min(Math.min(dp[i][j-1], dp[j][i-1]), dp[i-1][j-1]) + 1
// then dpMax * dpMax

// solution2:
// find max histogram that ends with current point
// keep track of the max length of the shorter side of the histogram

class Solution {
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    if (m == 0) return 0;
    int n = matrix[0].length;
    if (n == 0) return 0;

    int[][] dp = new int[m+1][n+1];
    int maxLength = 0;
    for (int i=1; i<=m; i++) {
      for (int j=1; j<=n; j++) {
        if (matrix[i-1][j-1] == '1') {
          dp[i][j] = Math.min(
              Math.min(dp[i][j-1], dp[i-1][j]),
              dp[i-1][j-1]
              ) + 1;
          maxLength = Math.max(maxLength, dp[i][j]);
        }
      }
    }
    return maxLength * maxLength;
  }
}

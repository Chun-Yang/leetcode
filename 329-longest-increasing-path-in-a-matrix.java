// Given an integer matrix, find the length of the longest increasing path.

// From each cell, you can either move to four directions: left, right, up or
// down. You may NOT move diagonally or move outside of the boundary (i.e.
//     wrap-around is not allowed).

// Example 1:

// nums = [
//   [9,9,4],
//   [6,6,8],
//   [2,1,1]
// ]
// Return 4
// The longest increasing path is [1, 2, 6, 9].

// Example 2:

// nums = [
//   [3,4,5],
//   [3,2,6],
//   [2,2,1]
// ]
// Return 4
// The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

import java.util.*;

class Solution {
  public static void main (String[] args) {
    Solution s = new Solution();
    int[][] nums = new int[][]{
      new int[]{9,9,4},
      new int[]{6,6,8},
      new int[]{2,1,1}
    };
    s.longestIncreasingPath(nums);

  }
  public int longestIncreasingPath(int[][] matrix) {
    int m = matrix.length;
    if (m == 0) return 0;
    int n = matrix[0].length;
    if (n == 0) return 0;

    int[][] cache = new int[m][n];
    for (int i=0; i<m; i++) Arrays.fill(cache[i], 0);

    int longestCount = 0;
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        longestCount = Math.max(longestCount, dfs(matrix, i, j, m, n, cache));
      }
    }
    return longestCount;
  }

  private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
    if (cache[i][j] > 0) return cache[i][j];

    int pathLength = 1;
    int[][] moves = new int[][] {
      new int[]{ 0, 1 },
      new int[]{ 0, -1 },
      new int[]{ 1, 0 },
      new int[]{ -1, 0 }
    };
    for (int[] move : moves) {
      int nextI = i + move[0];
      int nextJ = j + move[1];
      if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || matrix[i][j] >= matrix[nextI][nextJ]) continue;
      pathLength = Math.max(pathLength, 1 + dfs(matrix, nextI, nextJ, m, n, cache));
    }

    cache[i][j] = pathLength;
    return pathLength;
  }
}

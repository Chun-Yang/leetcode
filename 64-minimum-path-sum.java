import java.util.Arrays;

// Solution2: dp
// time: O(mn) space: O(n)
class Solution {
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    if (m == 0) return 0;
    int n = grid[0].length;
    if (n == 0) return 0;

    int[] paths = new int[n];

    paths[0] = grid[0][0];

    for (int j=1; j<n; j++) paths[j] = paths[j-1] + grid[0][j];

    for (int i=1; i<m; i++) {
      paths[0] += grid[i][0];
      for (int j=1; j<n; j++) {
        paths[j] = Math.min(paths[j-1], paths[j]) + grid[i][j];
      }
    }

    return paths[n-1];
  }
}

// Solution1: dp
// time: O(mn) space: O(mn)
// class Solution {
//   public int minPathSum(int[][] grid) {
//     int m = grid.length;
//     int n = grid[0].length;
//     int[][] dp = new int[m][n];

//     dp[0][0] = grid[0][0];

//     for (int i = 1; i < m; i++) {
//       dp[i][0] = dp[i - 1][0] + grid[i][0];
//     }

//     for (int j = 1; j < n; j++) {
//       dp[0][j] = dp[0][j - 1] + grid[0][j];
//     }

//     for (int i = 1; i < m; i++) {
//       for (int j = 1; j < n; j++) {
//         dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//       }
//     }
//     return dp[m-1][n-1];
//   }

//   public static void main (String[] args) {
//     Solution s = new Solution();

//     int[][] grid0 = {{ 1 }};
//     assert s.minPathSum(grid0) == 1;

//     int[][] grid1 = {{ 0, 0 }, { 0, 0 }};
//     assert s.minPathSum(grid1) == 0;

//     int[][] grid2 = {{ 0, 1 }, { 1, 0 }};
//     assert s.minPathSum(grid2) == 1;
//   }
// }

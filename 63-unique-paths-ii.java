// Follow up for "Unique Paths":
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
// [
// [0,0,0],
// [0,1,0],
// [0,0,0]
// ]
//
// The total number of unique paths is 2.
//
// Note: m and n will be at most 100.


// https://leetcode.com/problems/unique-paths-ii

// solution1: dp
// time: O(m*n) space: O(m*n)
// NOTE: we can improve the space complexity to O(Math.min(m,n))
class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] paths = new int[m][n];
    paths[0][0] = (1-obstacleGrid[0][0]);
    for (int i=1; i<m; i++) {
      paths[i][0] = paths[i-1][0] * (1 - obstacleGrid[i][0]);
    }
    for (int j=1; j<n; j++) {
      paths[0][j] = paths[0][j-1] * (1 - obstacleGrid[0][j]);
    }
    for (int i=1; i<m; i++) {
      for (int j=1; j<n; j++) {
        paths[i][j] = (1 - obstacleGrid[i][j]) * (paths[i-1][j] + paths[i][j-1]);
      }
    }
    return paths[m-1][n-1];
  }
}

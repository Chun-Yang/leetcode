public class Solution {
  public int numIslands(char[][] grid) {
    int m = grid.length;
    if (m == 0) return 0;
    int n = grid[0].length;
    if (n == 0) return 0;

    int count = 0;
    boolean[][] visited = new boolean[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          count++;
          dfs(i, j, m, n, grid, visited);
        }
      }
    }
    return count;
  }
  private void dfs(int i, int j, int m, int n, char[][] grid, boolean[][] visited) {
    if (grid[i][j] == '1' && !visited[i][j]) {
      visited[i][j] = true;
      if (i > 0) dfs(i-1, j, m, n, grid, visited);
      if (i < m - 1) dfs(i+1, j, m, n, grid, visited);
      if (j > 0) dfs(i, j-1, m, n, grid, visited);
      if (j < n - 1) dfs(i, j+1, m, n, grid, visited);
    }
  }
}

public class Solution {
  public boolean exist(char[][] board, String word) {
    // NOTE: we assume word.length() >= 1
    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (dfs(board, word, 0, visited, i, j, m, n)) return true;
      }
    }

    return false;
  }

  private boolean dfs(char[][] board, String word, int index, boolean[][] visited, int i, int j, int m, int n) {
    if (word.length() == index) return true;

    if (
        i<0 || i==m || j<0 || j==n ||
        visited[i][j] ||
        board[i][j] != word.charAt(index)
        ) return false;

    visited[i][j] = true;
    if (
        dfs(board, word, index+1, visited, i-1, j, m, n) ||
        dfs(board, word, index+1, visited, i+1, j, m, n) ||
        dfs(board, word, index+1, visited, i, j-1, m, n) ||
        dfs(board, word, index+1, visited, i, j+1, m, n)
        ) return true;
    visited[i][j] = false;

    return false;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.exist(new char[][] {
      { 'A', 'B', 'C', 'E' },
      { 'S', 'F', 'C', 'S' },
      { 'A', 'D', 'E', 'E' }
    }, "ABCCED");
  }
}

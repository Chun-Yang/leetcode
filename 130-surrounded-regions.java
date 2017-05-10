public class Solution {
  private class Pair {
    Pair(int x, int y) {
      i = x;
      j = y;
    }
    int i;
    int j;
  }
  public void solve(char[][] board) {
    int m = board.length;
    if (m <= 2) return;
    int n = board[0].length;
    if (n <= 2) return;

    Stack<Pair> starts = new Stack<Pair>();

    // dfs 'O' => '*'
    for (int j=0; j<n-1; j++) {
      if (board[0][j] == 'O') starts.push(new Pair(0, j));
    }
    for (int i=0; i<m-1; i++) {
      if (board[i][n-1] == 'O') starts.push(new Pair(i, n-1));
    }
    for (int j=n-1; j>0; j--) {
      if (board[m-1][j] == 'O') starts.push(new Pair(m-1, j));
    }
    for (int i=m-1; i>0; i--) {
      if (board[i][0] == 'O') starts.push(new Pair(i, 0));
    }

    // 'O' => '*'
    while (!starts.empty()) {
      Pair p = starts.pop();
      int i = p.i;
      int j = p.j;
      board[i][j] = '*';
      // up
      if (i>0 && board[i-1][j] == 'O') {
        starts.push(new Pair(i-1, j));
      }
      // right
      if (j<n-1 && board[i][j+1] == 'O') {
        starts.push(new Pair(i, j+1));
      }
      // down
      if (i<m-1 && board[i+1][j] == 'O') {
        starts.push(new Pair(i+1, j));
      }
      // left
      if (j>0 && board[i][j-1] == 'O') {
        starts.push(new Pair(i, j-1));
      }
    }

    // '*' => 'O', 'O' => 'X'
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (board[i][j] == '*') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }
}

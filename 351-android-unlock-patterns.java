// Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n
// ≤ 9, count the total number of unlock patterns of the Android lock screen,
//   which consist of minimum of m keys and maximum n keys.

// Rules for a valid pattern:

// Each pattern must connect at least m keys and at most n keys.
// All the keys must be distinct.
// If the line connecting two consecutive keys in the pattern passes through any
// other keys, the other keys must have previously selected in the pattern. No
// jumps through non selected key is allowed.
// The order of keys used matters.




// Explanation:

// | 1 | 2 | 3 |
// | 4 | 5 | 6 |
// | 7 | 8 | 9 |


// Invalid move: 4 - 1 - 3 - 6
// Line 1 - 3 passes through key 2 which had not been selected in the pattern.

// Invalid move: 4 - 1 - 9 - 2
// Line 1 - 9 passes through key 5 which had not been selected in the pattern.

// Valid move: 2 - 4 - 1 - 3 - 6
// Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

// Valid move: 6 - 5 - 4 - 1 - 9 - 2
// Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

// Example:
// Given m = 1, n = 1, return 9.

import java.util.*;

class Solution {
  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.numberOfPatterns(1, 1) == 9;
    assert s.numberOfPatterns(2, 2) == 56;
    // assert s.numberOfPatterns(1, 2) == 65;
  }
  public int numberOfPatterns(int m, int n) {
    int CELL_COUNT = 9;
    int count = 0;
    // create cross
    int[][] cross = new int[CELL_COUNT][CELL_COUNT];
    for (int i=0; i<CELL_COUNT; i++) Arrays.fill(cross[i], -1);
    cross[0][2] = 1;
    cross[0][6] = 3;
    cross[0][8] = 4;
    cross[2][0] = 1;
    cross[2][6] = 4;
    cross[2][8] = 5;
    cross[6][0] = 3;
    cross[6][2] = 4;
    cross[6][8] = 7;
    cross[8][0] = 4;
    cross[8][2] = 5;
    cross[8][6] = 7;
    cross[1][7] = 4;
    cross[3][5] = 4;
    cross[5][3] = 4;
    cross[7][1] = 4;

    boolean[] visited = new boolean[CELL_COUNT];
    for (int i=m; i<=n; i++) {
      for (int start=0; start<CELL_COUNT; start++) {
        // back tracking
        visited[start] = true;
        count += dfs(i-1, start, visited, cross);
        visited[start] = false;
      }
    }
    return count;
  }

  int dfs(int movesLeft, int lastMove, boolean[] visited, int[][] cross) {
    if (movesLeft == 0) return 1;

    int count = 0;
    for (int i=0; i<9; i++) {
      if (!visited[i] && (cross[lastMove][i] == -1 || visited[cross[lastMove][i]])) {
        visited[i] = true;
        count += dfs(movesLeft - 1, i, visited, cross);
        visited[i] = false;
      }
    }
    return count;
  }
}

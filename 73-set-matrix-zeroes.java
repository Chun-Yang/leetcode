import java.util.Arrays;

public class Solution {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    if (m == 0) return;
    int n = matrix[0].length;
    if (n == 0) return;

    boolean firstRow = false;
    boolean firstCol = false;

    // record all zero states
    for (int j=0; j<n; j++) {
      if (matrix[0][j] == 0) {
        firstRow = true;
        break;
      }
    }

    for (int i=0; i<m; i++) {
      if (matrix[i][0] == 0) {
        firstCol = true;
        break;
      }
    }

    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    // apply all zero states
    // NOTE: the order matters
    for (int i=1; i<m; i++) {
      for (int j=1; j<n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (firstRow) {
      for (int j=0; j < n; j++) matrix[0][j] = 0;
    }

    if (firstCol) {
      for (int i=0; i < m; i++) matrix[i][0] = 0;
    }
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

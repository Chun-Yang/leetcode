// Given a 2D matrix matrix, find the sum of the elements inside the rectangle
// defined by its upper left corner (row1, col1) and lower right corner (row2,
//     col2).

public class NumMatrix {
  int[][] sums;

  public NumMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = m == 0 ? 0 : matrix[0].length;
    sums = new int[m + 1][n + 1];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        sums[i+1][j+1] = matrix[i][j] + sums[i][j+1] + sums[i+1][j] - sums[i][j];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sums[row2+1][col2+1] - sums[row1][col2+1] - sums[row2+1][col1] + sums[row1][col1];
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;
    if (n == 0) return false;

    // exclution
    int x = 0;
    int y = n - 1;
    while (x < m && y >= 0) {
      if (matrix[x][y] > target) y--;
      else if (matrix[x][y] < target) x++;
      else return true;
    }
    return false;
  }
}

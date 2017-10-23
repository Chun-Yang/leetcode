// Write an efficient algorithm that searches for a value in an m x n matrix.
// This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,

// Consider the following matrix:

// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.

// Solution1: binary search, treat it as a 1-d array by using index properly
import java.util.Arrays;

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;
    if (n == 0) return false;

    int lo = 0;
    int hi = m * n - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int current = matrix[mid / n][mid % n];
      if (current < target) {
        lo = mid + 1;
      } else if (current > target) {
        hi = mid - 1;
      } else {
        return true;
      }
    }

    return matrix[lo / n][lo % n] == target;
  }
  public static void main (String[] args) {
    Solution s = new Solution();

    int[][] m1 = {{1, 2, 3}, {4, 5, 7}};
    assert s.searchMatrix(m1, 0) == false;
    assert s.searchMatrix(m1, 8) == false;
    assert s.searchMatrix(m1, 6) == false;
    assert s.searchMatrix(m1, 4) == true;

    int[][] m2 = {{1}};
    assert s.searchMatrix(m2, 1) == true;
  }
}

// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//
// For example,
// Given n = 3,
//
// You should return the following matrix:
//
// [
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
// ]


// https://leetcode.com/problems/spiral-matrix-ii

class Solution {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];

    int start = 0;
    int end = n - 1;

    int value = 1;
    while (start < end) {
      for (int j=start; j<end; j++) matrix[start][j] = value++;
      for (int i=start; i<end; i++) matrix[i][end] = value++;
      for (int j=end; j>start; j--) matrix[end][j] = value++;
      for (int i=end; i>start; i--) matrix[i][start] = value++;
      start++;
      end--;
    }

    if (start == end) matrix[start][end] = value;

    return matrix;
  }
}

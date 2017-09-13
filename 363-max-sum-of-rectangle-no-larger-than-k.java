// Given a non-empty 2D matrix matrix and an integer k, find the max sum of a
// rectangle in the matrix such that its sum is no larger than k.

// Example:
// Given matrix = [
//   [1,  0, 1],
//   [0, -2, 3]
// ]
// k = 2
// The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2
// is the max number no larger than k (k = 2).

// Note:
// The rectangle inside the matrix must have an area > 0.
// What if the number of rows is much larger than the number of columns?

import java.util.*;

class Solution {
  public int maxSumSubmatrix(int[][] matrix, int k) {
    int m = matrix.length;
    int n = matrix[0].length;

    // get areas
    int [][] areas = new int[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        int area = matrix[i][j];
        if (i > 0) area += areas[i-1][j];
        if (j > 0) area += areas[i][j-1];
        if (i > 0 && j > 0) area -= areas[i-1][j-1];
        areas[i][j] = area;
      }
    }

    // use hashset to get better performance
    int maxSum = Integer.MIN_VALUE;

    // // when rows >> columns
    for (int c1=0; c1<n; c1++) {
      for (int c2=c1; c2<n; c2++) {
        TreeSet<Integer> previousAreas = new TreeSet<>();
        previousAreas.add(0);
        for (int r=0; r<m; r++) {
          int currentArea = areas[r][c2];
          if (c1 > 0) currentArea -= areas[r][c1-1];
          Integer previousArea = previousAreas.ceiling(currentArea - k);
          if (previousArea != null) maxSum = Math.max(maxSum, currentArea - previousArea);
          previousAreas.add(currentArea);
        }
      }
    }

    // // when rows << columns
    // for (int r1=0; r1<m; r1++) {
    //   for (int r2=r1; r2<m; r2++) {
    //     TreeSet<Integer> previousAreas = new TreeSet<>();
    //     previousAreas.add(0);
    //     for (int c=0; c<n; c++) {
    //       int currentArea = areas[r2][c];
    //       if (r1 > 0) currentArea -= areas[r1-1][c];
    //       Integer previousArea = previousAreas.ceiling(currentArea - k);
    //       if (previousArea != null) maxSum = Math.max(maxSum, currentArea - previousArea);
    //       previousAreas.add(currentArea);
    //     }
    //   }
    // }

    return maxSum;
  }
}

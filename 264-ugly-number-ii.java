// Write a program to find the n-th ugly number.
//
//
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
// For example,
// 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
//
//
//
// Note that 1 is typically treated as an ugly number, and n does not exceed 1690.


// https://leetcode.com/problems/ugly-number-ii

// solution1: dp + pointers
// indexes: [0, 0, 0]
// 1, 2, 3, 4, 5, 6 ...

public class Solution {
  public int nthUglyNumber(int n) {
    int[] indexes = new int[3];
    int[] uglyNums = new int[n];
    int[] bases = new int[] {2, 3, 5};
    uglyNums[0] = 1;
    for (int i=1; i<n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j=0; j<3; j++) {
        min = Math.min(uglyNums[indexes[j]] * bases[j], min);
      }
      uglyNums[i] = min;
      for (int j=0; j<3; j++) {
        if (min == uglyNums[indexes[j]] * bases[j]) {
          indexes[j]++;
        }
      }
    }
    return uglyNums[n-1];
  }
}

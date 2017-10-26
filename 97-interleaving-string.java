// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//
//
// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",
//
//
// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.


// https://leetcode.com/problems/interleaving-string

// solution1:
// dp bottom-up
// time O(m * n) space O(m * n)

class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int n1 = s1.length();
    int n2 = s2.length();
    int n3 = s3.length();
    if (n1 + n2 != n3) return false;
    boolean[][] matrix = new boolean[n1+1][n2+1];
    matrix[0][0] = true;
    for (int i1=1; i1<=n1; i1++) {
      matrix[i1][0] = matrix[i1-1][0] && s1.charAt(i1-1) == s3.charAt(i1-1);
    }
    for (int i2=1; i2<=n2; i2++) {
      matrix[0][i2] = matrix[0][i2-1] && s2.charAt(i2-1) == s3.charAt(i2-1);
    }
    for (int i1=1; i1<=n1; i1++) {
      for (int i2=1; i2<=n2; i2++) {
        matrix[i1][i2] = (
            (matrix[i1-1][i2] && s1.charAt(i1-1) == s3.charAt(i1 + i2 - 1)) ||
            (matrix[i1][i2-1] && s2.charAt(i2-1) == s3.charAt(i1 + i2 - 1))
            );
      }
    }
    return matrix[n1][n2];
  }
}

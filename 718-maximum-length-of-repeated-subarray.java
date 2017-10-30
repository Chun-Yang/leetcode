// Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

// Example 1:
// Input:
// A: [1,2,3,2,1]
// B: [3,2,1,4,7]
// Output: 3
// Explanation:
// The repeated subarray with maximum length is [3, 2, 1].
// Note:
// 1 <= len(A), len(B) <= 1000
// 0 <= A[i], B[i] < 100

// solution1: match starts, then match till end
// time O(m * n * max(m, n)) space O(1)
class Solution {
  public int findLength(int[] A, int[] B) {
    int maxLength = 0;
    for (int i=0; i<A.length; i++) {
      if (i + maxLength > A.length) {
        continue;
      }
      for (int j=0; j<B.length; j++) {
        if (j + maxLength > B.length) {
          continue;
        }
        int l = 0;
        while (i+l < A.length && j+l < B.length && A[i+l] == B[j+l]) {
          l++;
        }
        maxLength = Math.max(maxLength, l);
      }
    }
    return maxLength;
  }
}
// solution2: we can skip to the end for the first array, make the
// first array the shorter one

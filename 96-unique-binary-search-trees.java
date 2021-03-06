// Given n, how many structurally unique BST's (binary search trees)
// that store values 1...n?
//
//
// For example,
// Given n = 3, there are a total of 5 unique BST's.
//
//
// 1         3     3      2      1
// \       /     /      / \      \
// 3     2     1      1   3      2
// /     /       \                 \
// 2     1         2                 3


// https://leetcode.com/problems/unique-binary-search-trees

// solution1:
// dp from pattern
// time: O(n ^ 2) space: O(n)
class Solution {
  public int numTrees(int n) {
    int[] counts = new int[n+1];
    counts[0] = 1;
    for (int i=1; i<=n; i++) {
      for (int j=0; j<i; j++) {
        counts[i] += counts[j] * counts[i-1-j];
      }
    }
    return counts[n];
  }
}

// solution2: catalan tree
// https://discuss.leetcode.com/topic/13321/a-very-simple-and-straight-ans-based-on-math-catalan-number-o-n-times-o-1-space

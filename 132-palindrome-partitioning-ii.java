// Given a string s, partition s such that every substring of the partition is a palindrome.
//
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
//
// For example, given s = "aab",
// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.


// https://leetcode.com/problems/palindrome-partitioning-ii

// solution1: dp + dp
// - boolean matrix[i][j] indicates palindrome substring
// - for each prefix, we find the palindromes that ends with the current ends
//   and lengths[i] = min(lengths[i-palindromeLength] + 1) for each palindromLength
//   time O(n ^ 2)

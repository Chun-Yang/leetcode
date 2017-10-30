// Given a string s,
// partition s such that every substring of the partition is a palindrome.
//
//
// Return all possible palindrome partitioning of s.
//
//
// For example, given s = "aab",
//
// Return
//
// [
// ["aa","b"],
// ["a","a","b"]
// ]


// https://leetcode.com/problems/palindrome-partitioning

// solution1: dp + backtracking
// - build a palindrome matrix palindrome[i][j] (start and end)
//   do it by length of string using dp
//   time: O(n ^ 2) space: O(n ^ 2)
// - backtracking
//   time: O(2 ^ n)
//   for each char, we can put it to the previous group or start a new group

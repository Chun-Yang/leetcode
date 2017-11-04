// An edit between two strings is one of the following changes.

// - Add a character
// - Delete a character
// - Change a character

// Given two string s1 and s2, find if s1 can be converted to s2 with exactly
// one edit. Expected time complexity is O(m+n) where m and n are lengths of
// two strings.



// https://leetcode.com/problems/one-edit-distance

// solution1: two pointers
// - find if length same
// - diff 0:
//   find change, should be 1
// - diff 1:
//   find change, shift one when diff found
// - dfff more than 1: false

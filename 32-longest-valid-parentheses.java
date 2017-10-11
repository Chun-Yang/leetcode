// Given a string containing just the characters '(' and ')', find the length
// of the longest valid (well-formed) parentheses substring.
//
//
// For "(()", the longest valid parentheses substring is "()",
// which has length = 2.
//
//
// Another example is ")()())", where the longest valid parentheses substring
// is "()()", which has length = 4.


// https://leetcode.com/problems/longest-valid-parentheses
// Solution1: track lefts and rights
// - rights is larger, start from here
// - left is larger, use the right to calculate length

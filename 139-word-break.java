// Given a non-empty string s and a dictionary wordDict containing a list of
// non-empty words, determine if s can be segmented into a space-separated
// sequence of one or more dictionary words. You may assume the dictionary does
// not contain duplicate words.
//
//
// For example, given
// s = "leetcode",
// dict = ["leet", "code"].
//
//
//
// Return true because "leetcode" can be segmented as "leet code".

// https://leetcode.com/problems/word-break

// solution1: dp
// time O(n ^ 2) for each of the position,
// we check if previous string is in the set

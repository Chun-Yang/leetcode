// Given a non-empty string s and a dictionary wordDict containing a list of
// non-empty words, add spaces in s to construct a sentence where each word is
// a valid dictionary word. You may assume the dictionary does not contain
// duplicate words.
//
//
//
// Return all such possible sentences.
//
//
//
// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].
//
//
//
// A solution is ["cats and dog", "cat sand dog"].


// https://leetcode.com/problems/word-break-ii

// solution1: dp

// solution2: dfs, this is more memory efficient
// two ways:
// - loop through string length
// - loop throuth the dictionary

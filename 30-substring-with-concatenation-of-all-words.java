// You are given a string, s, and a list of words, words, that are all of the
// same length.
// Find all starting indices of substring(s) in s that is a
// concatenation of each word in words exactly once and without any intervening
// characters.
//
//
//
// For example, given:
// s: "barfoothefoobarman"
// words: ["foo", "bar"]
//
//
//
// You should return the indices: [0,9].
// (order does not matter).


// https://leetcode.com/problems/substring-with-concatenation-of-all-words

// Solution1: for each window that contains char count equals to words char count,
// we check if we can form a substring
// n is the length of string
// m is the length of words
// time O(n * m!)
class Solution {
  public List<Integer> findSubstring(String s, String[] words) {

  }
}

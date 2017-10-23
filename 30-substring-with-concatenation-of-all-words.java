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
// https://discuss.leetcode.com/topic/6617/an-o-n-solution-with-detailed-explanation/10

// l is the length of string
// wl is the length of each word
// n is the count of words

// Solution2:
// we maintain wl sliding windows
// for each sliding window, we slide through the whole string
// using (l / wl) checks and each check cost wl for hashing
// time O(l * wl)

// Solution1:
// for each window that contains char count equals to words char count,
// we check if we can form a substring
// time O(l * n * wl)
// for each index, we check all the words in side window, each hash lookup
// is wl

class Solution {
  public List<Integer> findSubstring(String s, String[] words) {

  }
}

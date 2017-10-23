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

import java.util.*;
class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    // check for edge cases
    int l = s.length();
    int n = words.length;
    if (n == 0) return new ArrayList<Integer>();
    int wl = words[0].length();
    if (l < n * wl) return new ArrayList<Integer>();

    // create counter of words
    HashMap<String, Integer> counter = new HashMap<>();
    for (String word : words) counter.put(word, counter.getOrDefault(word, 0) + 1);

    // for each sliding windows
    List<Integer> starts = new ArrayList<Integer>();
    int maxI = Math.min(wl - 1, l - n * wl);
    for (int i=0; i<=maxI; i++) {
      // slide through the whole string
      HashMap<String, Integer> curCounter = new HashMap<>(counter);
      for (int end=i+wl; end <= l; end += wl) {
        // add to window
        String toAdd = s.substring(end - wl, end);
        curCounter.put(toAdd, curCounter.getOrDefault(toAdd, 0) - 1);
        if (curCounter.get(toAdd) == 0) curCounter.remove(toAdd);
        // remove from window
        // n = 1
        // wl = 2
        // 0 1 2 3 4 5
        // [ ]
        //   [ ]
        int start = end - n * wl;
        if (start > i) {
          String toRemove = s.substring(start - wl, start);
          curCounter.put(toRemove, curCounter.getOrDefault(toRemove, 0) + 1);
          if (curCounter.get(toRemove) == 0) curCounter.remove(toRemove);
        }
        if (curCounter.isEmpty()) starts.add(start);
      }
    }

    return starts;
  }

}

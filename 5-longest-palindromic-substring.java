// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example:
// Input: "babad"
//
// Output: "bab"
//
// Note: "aba" is also a valid answer.
//
//
//
// Example:
// Input: "cbbd"
//
// Output: "bb"


// https://leetcode.com/problems/longest-palindromic-substring

// solution1: for each position in the string (including splits), expand to fullest palindrom
// time O(N ^ 2), space O(1)
// solution2: dp [a, b, d, b]
class Solution {
  public String longestPalindrome(String s) {
    if (s.length() == 0) return "";

    char[] chars = s.toCharArray();
    int maxStart = 0;
    int maxEnd = 0;
    // odd length
    for (int center=0; center<chars.length; center++) {
      int start = center;
      int end = center;
      while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
        if (end - start > maxEnd - maxStart) {
          maxEnd = end;
          maxStart = start;
        }
        start--;
        end++;
      }
    }
    // even length
    for (int center=0; center<chars.length-1; center++) {
      int start = center;
      int end = center+1;
      while (start >= 0 && end <= chars.length - 1 && chars[start] == chars[end]) {
        if (end - start > maxEnd - maxStart) {
          maxEnd = end;
          maxStart = start;
        }
        start--;
        end++;
      }
    }

    return s.substring(maxStart, maxEnd + 1);
  }
}

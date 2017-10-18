// Implement wildcard pattern matching with support for '?' and '*'.
//
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
//
// The matching should cover the entire input string (not partial).
//
// The function prototype should be:
// bool isMatch(const char *s, const char *p)
//
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false


// https://leetcode.com/problems/wildcard-matching

// solution1: dp
class Solution {
  public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    // NOTE: the indexes are the length of the prefixes of s and p
    boolean[][] match = new boolean[m + 1][n + 1];

    match[0][0] = true;
    // match[i][0] = false where i [1, n]
    for (int j=1; j<=n; j++) {
      if (p.charAt(j-1) == '*') match[0][j] = true;
      else break;
    }

    // NOTE: i and j are the length of the prefixes
    for (int i=1; i<=m; i++) {
      for (int j=1; j<=n; j++) {
        char sChar = s.charAt(i-1);
        char pChar = p.charAt(j-1);
        if (pChar == '?') match[i][j] = match[i-1][j-1];
        else if (pChar == '*') {
          // * matches 0 char, 1 char, and more than 1 char
          match[i][j] = match[i][j-1] || match[i-1][j-1] || match[i-1][j];
        }
        else match[i][j] = match[i-1][j-1] && sChar == pChar;
      }
    }

    return match[m][n];
  }
}

// solution2: two pointers
// https://discuss.leetcode.com/topic/3040/linear-runtime-and-constant-space-solution
// match the string first, check the rest of pattern are * only

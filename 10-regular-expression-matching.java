// Implement regular expression matching with support for '.' and '*'.
//
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
//
// The matching should cover the entire input string (not partial).
//
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true


// https://leetcode.com/problems/regular-expression-matching

// Solution1 DP
class Solution {
  public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    char[] sChars = s.toCharArray();
    char[] pChars = p.toCharArray();
    // NOTE: the index are for ends
    boolean[][] match = new boolean[m + 1][n + 1]; // 0, 0 is for empty strings
    match[0][0] = true;
    for (int i=1; i<=m; i++) match[i][0] = false;
    for (int j=1; j<=n; j++) {
      match[0][j] = pChars[j-1] == '*' && match[0][j-2];
    }

    for (int i=1; i<=m; i++) {
      for (int j=1; j<=n; j++) {
        // i-1, j
        // i, j-1
        // i-1, j-1
        // match[i][j] = (match[i-1][j] && pChars[j-1] == '*' && pChars[j-2] == sChars[i-1])
        //   || (match[i][j-1] && (pChars[j-1] == '*' || (pChars[j-2] == '*' && (pChars[j-1] == sChars[i-1] || pChars[j-1] == '.'))))
        //   || (match[i-1][j-1] && (pChars[j-1] == '*' || pChars[j-1] == sChars[i-1] || pChars[j-1] == '.'));
        if (pChars[j-1] == '*') {
          // if (match[i][j-2]) {
          //   match[i][j] = true;
          // } else {
          //   for (int preI = i-1; preI >= 0 && (sChars[preI] == pChars[j-2] || pChars[j-2] == '.'); preI--) {
          //     if (match[preI][j-2]) {
          //       match[i][j] = true;
          //       break;
          //     }
          //   }
          // }
          if (pChars[j-2] != '.' && pChars[j-2] != sChars[i-1]) match[i][j] = match[i][j-2];
          // ?* match 0, ? match 1 and * match 0, ? match 1 and * match 1
          else match[i][j] = match[i][j-2] || match[i][j-1] || match[i-1][j];
        } else if (pChars[j-1] == '.') {
          match[i][j] = match[i-1][j-1];
        } else {
          match[i][j] = sChars[i-1] == pChars[j-1] && match[i-1][j-1];
        }
      }
    }

    return match[m][n];
  }
}

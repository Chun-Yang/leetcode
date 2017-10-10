// Given a string s and a string t, check if s is subsequence of t.

// You may assume that there is only lower case English letters in both s and t. t
// is potentially a very long (length ~= 500,000) string, and s is a short string
// (<=100).

// A subsequence of a string is a new string which is formed from the original
// string by deleting some (can be none) of the characters without disturbing the
// relative positions of the remaining characters.
// (ie, "ace" is a subsequence of "abcde" while "aec" is not).

// Example 1:
// s = "abc", t = "ahbgdc"

// Return true.

// Example 2:
// s = "axc", t = "ahbgdc"

// Return false.

// Follow up:
// If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you
// want to check one by one to see if T has its subsequence. In this scenario, how
// would you change your code?

// Solution1 two pointers
// class Solution {
//   public boolean isSubsequence(String s, String t) {
//     if (s.length() == 0) return true;

//     int index = 0;
//     for (int i=0; i<t.length(); i++) {
//       if (s.charAt(index) == t.charAt(i)) index++;
//       if (index == s.length()) return true;
//     }
//     return false;
//   }
// }

// FOR follow up:
// Solution2 tri time: O(m), space: O(2^n)
// Solution3 TreeSet for different chars
// a [1,2,3,9,100]
// b [12,32,34]
// time: O(m * log(n)) space: O(n)
import java.util.*;

class Solution {
  HashMap<Character, TreeSet<Integer>> charMap;

  public boolean isSubsequence(String s, String t) {
    if (s.length() == 0) return true;

    charMap = new HashMap<>();
    for (char i='a'; i<='z'; i++) {
      charMap.put(i, new TreeSet<Integer>());
    }
    for (int i=0; i<t.length(); i++) {
      charMap.get(t.charAt(i)).add(i);
    }

    int start = 0;
    for (int i=0; i<s.length(); i++) {
      Integer index = charMap.get(s.charAt(i)).ceiling(start);
      if (index == null) return false;
      start = index + 1;
    }
    return true;
  }
}

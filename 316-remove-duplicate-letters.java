// Given a string which contains only lowercase letters, remove duplicate letters
// so that every letter appear once and only once. You must make sure your result
// is the smallest in lexicographical order among all possible results.

// Example:
// Given "bcabc"
// Return "abc"

// Given "cbacdcbc"
// Return "acdb"


class Solution {
  public String removeDuplicateLetters(String s) {
    if (s.length() == 0) return s;

    int[] count = new int[26];
    for (int i=0; i<s.length(); i++) count[s.charAt(i) - 'a']++;

    int minIndex = 0;
    for (int i=0; i<s.length(); i++) {
      if (s.charAt(i) < s.charAt(minIndex)) minIndex = i;
      count[s.charAt(i) - 'a']--;
      if (count[s.charAt(i) - 'a'] == 0) break;
    }
    String rest = s
      .substring(minIndex + 1)
      .replace(String.valueOf(s.charAt(minIndex)), "");
    return s.charAt(minIndex) + removeDuplicateLetters(rest);
  }
}

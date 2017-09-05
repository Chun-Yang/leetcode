// Given a string you need to print longest possible substring that has exactly M
// unique characters. If there are more than one substring of longest possible
// length, then print any one of them.

// Examples:

// "aabbcc", k = 1
// Max substring can be any one from {"aa" , "bb" , "cc"}.

// "aabbcc", k = 2
// Max substring can be any one from {"aabb" , "bbcc"}.

// "aabbcc", k = 3
// There are substrings with exactly 3 unique characters
// {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
// Max is "aabbcc" with length 6.

// "aaabbb", k = 3
// There are only two unique characters, thus show error message.

class Solution {
  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.longestSubstring("aabbcc", 1).equals("aa");
    assert s.longestSubstring("aabbcc", 2).equals("aabb");
    assert s.longestSubstring("aabbcc", 3).equals("aabbcc");
    assert s.longestSubstring("aababccd", 3).equals("aababcc");
  }
  String longestSubstring(String s, int k) {
    String maxString = "";
    // NOTE: start and end are inclusive [start, end]
    int start = 0;
    int countsOfUniqueChars = 0;
    int[] countByChar = new int[128];
    for (int end=0; end < s.length(); end++) {
      // add this char (the constain may be broken)
      if (countByChar[s.charAt(end)]++ == 0) countsOfUniqueChars++;
      // restore the constrain, increase start until countsOfUniqueChars <= k
      while(countsOfUniqueChars > k) {
        start++;
        if (--countByChar[s.charAt(start)] == 0) countsOfUniqueChars--;
      }
      // record maxString and maxLength
      if (end - start + 1 > maxString.length()) {
        maxString = s.substring(start, end + 1);
      }
    }
    return maxString;
  }
}

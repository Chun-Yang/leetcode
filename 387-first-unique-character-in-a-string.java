// Given a string, find the first non-repeating character in it and return it's
// index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.

import java.util.*;

// Solution 1 one pass + 256
// Solution 2 two pass
class Solution {
  public int firstUniqChar(String s) {
    int[] indexes = new int[256];
    Arrays.fill(indexes, -2);
    for (int i=0; i<s.length(); i++) {
      if (indexes[s.charAt(i)] == -2) indexes[s.charAt(i)] = i;
      else if (indexes[s.charAt(i)] >= 0) indexes[s.charAt(i)] = -1;
    }

    int index = -1;
    for (int i : indexes) {
      if (i>=0) index = index >= 0 ? Math.min(index, i) : i;
    }

    return index;
  }
}

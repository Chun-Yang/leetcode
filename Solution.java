// https://discuss.leetcode.com/topic/17639/20ms-detailed-explained-c-solutions-o-n-space
import java.util.Arrays;

public class Solution {
  public int minDistance(String word1, String word2) {
    String longWord;
    String shortWord;
    int longLen;
    int shortLen;
    if (word1.length() > word2.length()) {
      longWord = word1;
      shortWord = word2;
      longLen = word1.length();
      shortLen = word2.length();
    } else {
      longWord = word2;
      shortWord = word1;
      longLen = word2.length();
      shortLen = word1.length();
    }

    int[] matches = new int[shortLen + 1];
    Arrays.fill(matches, 0);

    for (int i=longLen - shortLen; i>=0; i--) {
      for (int j=shortLen - 1; j>=0; j--) {
        if (longWord.charAt(i + j) == shortWord.charAt(j)) {
          matches[j] = Math.max(matches[j], 1 + matches[j + 1]);
        } else {
          matches[j] = Math.max(matches[j], matches[j + 1]);
        }
      }
    }

    return longLen - matches[0];
  }

  public static void main (String[] args) {
    Solution s = new Solution();

    assert s.minDistance("", "") == 0;
    assert s.minDistance("a", "") == 1;
    assert s.minDistance("", "a") == 1;
    assert s.minDistance("ab", "cd") == 2;
    assert s.minDistance("ab", "ab") == 0;
  }
}

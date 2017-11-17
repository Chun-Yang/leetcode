// Write a function to find the longest common prefix string amongst an array of strings.


// https://leetcode.com/problems/longest-common-prefix

// solution1: for each string, we check if they all have the same prefix
// time O(m) (m is # of chars in all strs) space O(1)
class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";

    int minLength = Integer.MAX_VALUE;
    for (int i=0; i<strs.length; i++) minLength = Math.min(minLength, strs[i].length());

    for (int i=0; i<minLength; i++) {
      for (int j=1; j<strs.length; j++) {
        if (strs[j].charAt(i) != strs[0].charAt(i)) {
          return strs[0].substring(0, i);
        }
      }
    }

    return strs[0].substring(0, minLength);
  }
}

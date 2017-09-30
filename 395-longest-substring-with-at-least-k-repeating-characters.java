// Find the length of the longest substring T of a given string (consists of
// lowercase letters only) such that every character in T appears no less than
// k times.

// Example 1:

// Input:
// s = "aaabb", k = 3

// Output:
// 3

// The longest substring is "aaa", as 'a' is repeated 3 times.
// Example 2:

// Input:
// s = "ababbc", k = 2

// Output:
// 5

// The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
// repeated 3 times.

// Solution1: O(n) split at indexes where the frequence is low
class Solution {
  public int longestSubstring(String s, int k) {
    return splitAndCount(s.toCharArray(), 0, s.length() - 1, k);
  }
  // [start, end]
  private int splitAndCount(char[] chars, int start, int end, int k) {
    if (end - start + 1 < k) return 0;
    int[] counts = new int[26];
    for (int i=start; i<=end; i++) counts[chars[i] - 'a']++;
    for (int i=0; i<26; i++) {
      if (counts[i] > 0 && counts[i] < k) {
        int length = 0;
        int nextStart = start - 1;
        int nextEnd = start;
        for (int j=start; j<=end; j++) {
          if (counts[chars[j] - 'a'] >= k) {
            nextEnd = j;
          } else {
            length = Math.max(length, splitAndCount(chars, nextStart + 1, nextEnd, k));
            nextStart = j;
            nextEnd = j;
          }
        }
        length = Math.max(length, splitAndCount(chars, nextStart + 1, nextEnd, k));
        return length;
      }
    }
    return end - start + 1;
  }
}

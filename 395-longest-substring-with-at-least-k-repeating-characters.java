// Find the length of the longest substring T of a given string
// (consists of lowercase letters only)
// such that every character in T appears no less than k times.

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

// The longest substring is "ababb",
// as 'a' is repeated 2 times and 'b' is repeated 3 times.

import java.util.*;

// Solution1: We calculate counter for each index of s, get any pair to check
// if this is valid.
// time O(n ^ 2) space O(n) where n == s.length()
// class Solution {
//   public int longestSubstring(String s, int k) {
// }
// }

// Solution2:
// time O(n) space O(n)
// https://discuss.leetcode.com/topic/57596/java-strict-o-n-two-pointer-solution/2
// for each counts (1, 2, 3...26 letters) we maintain a window.
// if this windown is a a valid substring( all >=k ) then we record it
class Solution {
  public int longestSubstring(String s, int k) {
  }
}

// Solution3:
// time O(n) space O(n)
// https://discuss.leetcode.com/topic/57699/simple-java-o-n-solution
// remove one char at a time

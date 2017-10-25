// A message containing letters from A-Z is being encoded to numbers using the
// following mapping:
//
//
//
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
//
//
//
// Given an encoded message containing digits, determine the total number of
// ways to decode it.
//
//
//
// For example,
// Given encoded message "12",
// it could be decoded as "AB" (1 2) or "L" (12).
//
//
//
// The number of ways decoding "12" is 2.


// https://leetcode.com/problems/decode-ways

// solution1: dp
// length == 0 : 1
// ways[length]
// ways[0] = '1'-'9' ? 1 : 0
// ways[n] += ways[n-1] if current is not 0
// ways[n] += ways[n-2] if current last two is between 10 - 26
// time: O(n) space: O(1)

class Solution {
  public int numDecodings(String s) {
    int n = s.length();
    if (n == 0) return 0;

    if (s.charAt(0) == '0') return 0;

    char[] chars = s.toCharArray();
    int first = 1;
    int second = 1;
    for (int i=1; i<n; i++) {
      int third = 0;
      if (chars[i-1] == '1' || (chars[i-1] == '2' && chars[i] <= '6')) third += first;
      if (chars[i] != '0') third += second;
      first = second;
      second = third;
    }
    return second;
  }
}

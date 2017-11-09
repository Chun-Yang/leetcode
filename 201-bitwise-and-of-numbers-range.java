// Given a range [m, n] where 0 <= m <= n <= 2147483647,
// return the bitwise AND of all numbers in this range, inclusive.
//
// For example, given the range [5, 7], you should return 4.
//
//
// Credits:Special thanks to @amrsaqr for adding this problem and creating all test cases.


// https://leetcode.com/problems/bitwise-and-of-numbers-range

// solution1: bit add
// time: O(n) space: O(1)

// solution2:
// pattern:
// [0, 1] -> 1
// [011, 100] -> 111
// [1001, 1010] -> 111
// [0010, 1010] -> 1111
// [1000, 1010] -> 1111
// check if has same size of bits
// - no:  fill n with 1
// - yes: find the first bit that they are different fill the rest with 1

class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    int and = 0;
    for (int i=31; i>=0; i--) {
      if((m & (1 << i)) != (n & (1 << i))) break;
      and |= (n & (1 << i));
    }
    return and;
  }
}

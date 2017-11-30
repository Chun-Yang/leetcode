// Given an integer, write a function to determine if it is a power of two.
//
//
// Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.


// https://leetcode.com/problems/power-of-two

// solution1: remove the last bit and check if it's zero
// time O(1)

public class Solution {
  public boolean isPowerOfTwo(int n) {
    return (n > 0) && (n & (n-1)) == 0;
  }
}

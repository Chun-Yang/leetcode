// Given an array of integers, every element appears three times except for one,
// which appears exactly once. Find that single one.
//
//
//
// Note:
// Your algorithm should have a linear runtime complexity.
// Could you implement it without using extra memory?


// https://leetcode.com/problems/single-number-ii
// 0 -> 0, 0
// 1 -> 0, 1
// 2 -> 1, 0
// 3 -> 0, 0
// second = (first & num) ^ second
// first = (first | num) ^ preSecond

// first, second, num -> first
// 0      0       0      0
// 0      0       1      1
// 0      1       0      0
// 0      1       1      0
// 1      0       0      1
// 1      0       1      0
// nextFirst = num & (!first & !second)

// first, second, num -> second
// 0      0       0      0
// 0      0       1      0
// 0      1       0      1
// 0      1       1      0
// 1      0       0      0
// 1      0       1      1
// nextSecond = (second & !num) | (!second & first & num)

class Solution {
  public int singleNumber(int[] nums) {
    int first = 0;
    int second = 0;
    int nextFirst = 0;
    int nextSecond = 0;

    for (int num : nums) {
      nextFirst = ~second & (first ^ num);
      nextSecond = (second & ~num) | (first & num);
      first = nextFirst;
      second = nextSecond;
    }

    return first;
  }
}

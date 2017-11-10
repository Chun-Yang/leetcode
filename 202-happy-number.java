// Write an algorithm to determine if a number is "happy".
//
// A happy number is a number defined by the following process: Starting with
// any positive integer, replace the number by the sum of the squares of its
// digits, and repeat the process until the number equals 1
// (where it will stay),
// or it loops endlessly in a cycle which does not include 1. Those
// numbers for which this process ends in 1 are happy numbers.
//
// Example: 19 is a happy number
//
//
// 1^2 + 9^2 = 82
// 8^2 + 2^2 = 68
// 6^2 + 8^2 = 100
// 1^2 + 0^2 + 0^2 = 1
//
//
// Credits:Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.


// https://leetcode.com/problems/happy-number

// solution1: use a set to check if we are in a cycle

import java.util.*;

class Solution {
  public boolean isHappy(int n) {
    HashSet<Integer> previous = new HashSet<>();
    while (true) {
      if (n == 1) {
        return true;
      }
      n = getNext(n);
      if (previous.contains(n)) {
        return false;
      }
      previous.add(n);
    }
  }
  private int getNext(int n) {
    int nextN = 0;
    while (n > 0) {
      nextN += (n % 10) * (n % 10);
      n = n / 10;
    }
    return nextN;
  }
}

// solution2:
// https://discuss.leetcode.com/topic/12587/my-solution-in-c-o-1-space-and-no-magic-math-property-involved
// slow fast pointer

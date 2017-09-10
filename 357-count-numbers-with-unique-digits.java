// Given a non-negative integer n, count all numbers with unique digits,
// x, where 0 ≤ x < 10^n.

// Example:
// Given n = 2, return 91. (The answer should be the total numbers in the range of
// 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

class Solution {
  public int countNumbersWithUniqueDigits(int n) {
    int total = 1;

    int level = 9;
    // int zeroIncluded = 10;
    // int startWithZero = 1;
    for (int i=1; i<=Math.min(n, 10); i++) {
      total += level;
      level *= (10 - i);
      // total += (zeroIncluded - startWithZero);
      // zeroIncluded *= (10 - i);
      // startWithZero *= (10 - i);
    }

    return total;
  }
}

// Find the nth digit of the infinite integer sequence
// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

// Note:
// n is positive and will fit within the range of a 32-bit signed integer
// (n < 231).

// Example 1:
// Input:
// 3
// Output:
// 3

// Example 2:
// Input:
// 11
// Output:
// 0

// Explanation:
// The 11th digit of the sequence
// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0,
// which is part of the number 10.

class Solution {
  public int findNthDigit(int n) {
    int base = 1;
    long tens = 1;
    while(true) {
      if ((long)n > 9 * base * tens) {
        n -= 9 * base * tens;
        base += 1;
        tens *= 10;
      } else {
        long num = tens + (n - 1) / base;
        return Long.toString(num).charAt((n - 1) % base) - '0';
      }
    }
  }
}

// solution2: use divisions instead of multiplication to prevent overflow
// https://discuss.leetcode.com/topic/59378/short-python-java
// public int findNthDigit(int n) {
//     n -= 1;
//     int digits = 1, first = 1;
//     while (n / 9 / first / digits >= 1) {
//         n -= 9 * first * digits;
//         digits++;
//         first *= 10;
//     }
//     return (first + n/digits + "").charAt(n%digits) - '0';
// }

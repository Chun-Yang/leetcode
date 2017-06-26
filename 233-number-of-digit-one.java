// https://discuss.leetcode.com/topic/18054/4-lines-o-log-n-c-java-python/33
// cdai
// Basic idea: count number of combination of 1 at each digit in two cases: prefix appears or not
// Eg.3101592:
// 1) one at hundreds:      1 (< 5): [1~3101]1[0~99]. So # = 3101 * 100 + 100 (Safe since 31011XX never be greater than 31015XX)
// 2) one at thousands:     1 (= 1): [1~310]1[0~592]. So # = 310 * 1000 + (592 + 1) (Unsafe if prefix is 0, it must be <= 1592)
// 3) one at ten thousands: 1 (> 0): [1~30]1[0~9999]. So # = 30 * 10000 (If prefix is 0, no 1 digit number exist)

public class Solution {
  public int countDigitOne(int n) {
    // single digit
    if (n < 10) return n >= 1 ? 1 : 0;

    int count = 0;

    int exponent = 0;
    int digit = n;
    while (digit >= 10) {
      exponent++;
      digit /= 10;
    }

    int nextN = n - digit * (int)Math.pow(10, exponent);

    if (digit == 1) {
      // +1 is for 0
      count += nextN + 1;
    } else {
      // Math.pow(10, exponent) when 1 is the start
      count += Math.pow(10, exponent);
    }

    count += exponent * Math.pow(10, exponent - 1) * digit;

    count += countDigitOne(nextN);

    return count;
  }
}

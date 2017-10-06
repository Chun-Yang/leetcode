// Reverse digits of an integer.
//
//
// Example1: x =  123, return  321
// Example2: x = -123, return -321
//
//
// click to show spoilers.
//
// Have you thought about this?
//
// Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
//
// If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
//
// Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
//
// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//
//
//
//
//
// Note:
// The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.


// https://leetcode.com/problems/reverse-integer

import java.util.*;

// Solution1: use long
class Solution {
  public int reverse(int x) {
    boolean isNegative = x < 0;
    if (isNegative) x = -x;
    long y = 0;
    while (x > 0) {
      int digit = x % 10;
      y = y * 10 + digit;
      x /= 10;
    }
    if (isNegative ? -y < Integer.MIN_VALUE : y > Integer.MAX_VALUE ) return 0;
    return (int)(isNegative ? -y : y);
  }
}

// Solution2: check constrain violation
// https://discuss.leetcode.com/topic/6104/my-accepted-15-lines-of-code-for-java
// class Solution {
//   public int reverse(int x)
//   {
//       int result = 0;

//       while (x != 0)
//       {
//           int tail = x % 10;
//           int newResult = result * 10 + tail;
//           if ((newResult - tail) / 10 != result)
//           { return 0; }
//           result = newResult;
//           x = x / 10;
//       }

//       return result;
//   }
// }

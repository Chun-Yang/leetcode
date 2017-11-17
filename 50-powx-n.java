// Implement pow(x, n).

// solution1: binary search, rich to the top, then reduce (iterative)
// gredually (NOTE: this is not binary search the following is a good implement)
// https://discuss.leetcode.com/topic/40546/iterative-log-n-solution-with-clear-explanation

// solution2: recursive using odd and even (recursive)
// https://discuss.leetcode.com/topic/5425/short-and-easy-to-understand-solution

// Solution3: several approachs
// https://discuss.leetcode.com/topic/21837/5-different-choices-when-talk-with-interviewers

// recursive preorder
// class Solution {
//   public double myPow(double x, int n) {
//     if (n == Integer.MIN_VALUE) return 1 / x * myPow(x, n + 1);
//     if (n < 0) return myPow(1/x, -n);
//     if (n == 0) return 1;
//     double half = myPow(x, n / 2);
//     if (n % 2 == 0) return half * half;
//     return x * half * half;
//   }
// }

// recursive postorder (tail recursion)
// class Solution {
//   public double myPow(double x, int n) {
//     if (n == Integer.MIN_VALUE) return 1 / x * myPow(x, n + 1);
//     if (n < 0) return myPow(1/x, -n);
//     if (n == 0) return 1;
//     if (n % 2 == 0) return myPow(x*x, n / 2);
//     else return x * myPow(x*x, n / 2);
//   }
// }

// iterative
// y = x ^ (a1 + 2 * a2 + 4 * a3 ...)
// y = x ^ (a1) * x ^ (2 * a2) * ...
// where ai is 0 or 1
class Solution {
  public double myPow(double x, int n) {
    if (n == Integer.MIN_VALUE) return 1 / x * myPow(x, n + 1);
    if (n < 0) return myPow(1/x, -n);

    double pow = 1;
    double base = x;
    while (n > 0) {
      if (n % 2 == 1) pow *= base;
      base *= base;
      n /= 2;
    }
    return pow;
  }
}

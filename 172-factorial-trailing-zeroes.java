public class Solution {
  public int trailingZeroes(int n) {
    long nl = (long)n;
    long base = 5;
    int zeros = 0;
    while (n >= base && base <= Integer.MAX_VALUE) {
      zeros += n / base;
      base *= 5;
    }
    return zeros;
  }
}

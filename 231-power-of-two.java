public class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) return false;

    // return !(n & (n - 1))
    while (n > 0) {
      if ((n & 1) == 1) return n == 1;
      n >>= 1;
    }

    return true;
  }
}

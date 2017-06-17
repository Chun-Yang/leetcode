// https://discuss.leetcode.com/topic/12093/my-simple-java-solution-3-lines

public class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    int ml = countLength(m);
    int nl = countLength(n);
    if (nl > ml) return 0;

    int result = 0;
    for (int i=nl-1; i>=0; i--) {
      int mask = (1 << i);
      if ((m & mask) == (n & mask)) {
        result |= (m & mask);
      } else {
        break;
      }
    }

    return result;
  }
  private int countLength(int x) {
    int l = 0;
    while (x > 0) {
      l++;
      x >>= 1;
    }
    return l;
  }
}

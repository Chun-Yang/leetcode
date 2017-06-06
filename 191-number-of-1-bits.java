public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int w = 0;
    while (n != 0) {
      w += n & 1;
      n >>>= 1;
    }
    return w;
  }
}

public class Solution {
  public int numDecodings(String s) {
    int length = s.length();
    if (length == 0 || s.charAt(0) == '0') return 0;

    int[] counts = new int[length + 1];
    int c1 = 1;
    int c2 = 1;
    for (int i=2; i<=length; i++) {
      int c3 = 0;
      // single
      if (s.charAt(i-1) != '0') c3 += c2;
      // double
      if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) c3 += c1;

      if (c3 == 0) return 0;

      c1 = c2;
      c2 = c3;
    }
    return c2;
  }
  // public int numDecodings(String s) {
  //   int length = s.length();
  //   if (length == 0) return 0;

  //   if (s.charAt(0) == '0') {
  //     return 0;
  //   }

  //   int[] counts = new int[length + 1];
  //   counts[0] = 1;
  //   counts[1] = 1;
  //   for (int i=2; i<=length; i++) {
  //     // single
  //     if (s.charAt(i-1) != '0') counts[i] += counts[i-1];
  //     // double
  //     boolean canBeDouble = s.charAt(i-2) != '0'
  //       && Integer.parseInt(s.substring(i-2, i)) <= 26;
  //     if (canBeDouble) counts[i] += counts[i-2];

  //     if (counts[i] == 0) return 0;
  //   }
  //   return counts[length];
  // }
  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.numDecodings("") == 0;
    assert s.numDecodings("0") == 0;
    assert s.numDecodings("2") == 1;
    assert s.numDecodings("12") == 2;
    assert s.numDecodings("10") == 1;
  }
}

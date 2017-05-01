public class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int l1 = s1.length(),
        l2 = s2.length(),
        l3 = s3.length();
    if (l1 + l2 != l3) {
      return false;
    }
    boolean[][] cache = new boolean[l1 + 1][l2 + 1];
    cache[0][0] = true;
    for (int i=1; i<=l1; i++) {
      cache[i][0] = cache[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
    }
    for (int j=1; j<=l2; j++) {
      cache[0][j] = cache[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
    }
    for (int i=1; i<=l1; i++) {
      for (int j=1; j<=l2; j++) {
        cache[i][j] = (cache[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
          (cache[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
      }
    }
    return cache[l1][l2];
  }
}

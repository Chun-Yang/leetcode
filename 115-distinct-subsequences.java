public class Solution {
  public int numDistinct(String s, String t) {
    int m = s.length();
    int n = t.length();
    if (m < n) return 0;
    int[][] count = new int[m + 1][n + 1];
    for (int i=0; i<=m; i++) count[i][0] = 1;
    for (int i=1; i<=m; i++) {
      for (int j=1; j<=n; j++) {
        count[i][j] = count[i-1][j];
        if (s.charAt(i-1) == t.charAt(j-1)) count[i][j] += count[i-1][j-1];
      }
    }
    return count[m][n];
  }
}

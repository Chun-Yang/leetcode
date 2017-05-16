public class Solution {
  public int minCut(String s) {
    int length = s.length();
    if (length <= 1) return 0;

    boolean[][] valid = new boolean[length][length];
    for (int l=1; l<=length; l++) {
      for (int start=0; start<=length-l; start++) {
        int end = start + l - 1;
        valid[start][end] = s.charAt(start) == s.charAt(end) &&
          ( end - start <= 2 || valid[start+1][end-1] );
      }
    }

    int[] cut = new int[length];
    for (int i=0; i<length; i++) {
      if (!valid[0][i]) {
        cut[i] = i;
        for (int j=0; j<i; j++) {
          if (valid[j+1][i]) cut[i] = Math.min(cut[i], cut[j] + 1);
        }
      }
    }

    return cut[length - 1];
  }
}

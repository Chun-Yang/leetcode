import java.util.*;

public class Solution {
  public int getMoneyAmount(int n) {
    int[][] amounts = new int[n + 2][n + 2];
    for (int length=2; length<=n; length++) {
      for (int from=1; from + length - 1 <= n; from++) {
        int to = from + length - 1;
        amounts[from][to] = Integer.MAX_VALUE;
        for (int selected=from; selected<=to; selected++) {
          amounts[from][to] = Math.min(
            amounts[from][to],
            selected + Math.max(amounts[from][selected-1], amounts[selected+1][to])
          );
        }
      }
    }
    return amounts[1][n];
  }
  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.getMoneyAmount(2) == 1;
  }
}

import java.util.List;
import java.util.ArrayList;

public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    if (k > n) return new ArrayList<>();

    List<List<Integer>> combos = new ArrayList<List<Integer>>();

    ArrayList<Integer> combo = new ArrayList<Integer>();
    for (int i=1; i<=k; i++) combo.add(i);

    while (true) {
      combos.add(new ArrayList<Integer>(combo));

      boolean hasNext = false;
      for (int i=k; i>=1; i--) {
        // add one
        int nextValue = combo.get(i-1) + 1;
        // - if the value is too big, we do not set the value,
        // we keep the carry and wait for reset
        // - other wise, we do the add one and reset
        if (nextValue <= n - k + i) {
          hasNext = true;
          // add one
          combo.set(i-1, nextValue);
          // reset
          for (int j=i+1; j<=k; j++) {
            combo.set(j-1, nextValue + j - i);
          }
          break;
        }
      }

      if (!hasNext) {
        return combos;
      }
    }
  }
  public static void main (String[] args) {
    Solution s = new Solution();
    s.combine(5, 3);
  }
}

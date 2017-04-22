import java.util.List;
import java.util.ArrayList;

public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    if (k > n) return new ArrayList<>();

    List<List<Integer>> combos = new ArrayList<List<Integer>>();

    ArrayList<Integer> combo = new ArrayList<Integer>();
    for (int i=1; i<=k; i++) {
      combo.add(i);
    }

    while (true) {
      combos.add(combo);

      boolean hasNext = false;
      for (int i=k; i>=1; i--) {
        if (combo.get(i-1) == n - k + i) {
          if (i == 1) {
            hasNext = true;
            break;
          }
          combo.set(i-1, );
        } else {
          combo.set(i-1, combo.get(i-1) + 1);
          break;
        }
      }
      if (!hasNext) {
        break;
      }
    }

    return combos;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

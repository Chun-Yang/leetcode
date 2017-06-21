public class Solution {
  List<List<Integer>> combs;
  List<Integer> comb;
  public List<List<Integer>> combinationSum3(int k, int n) {
    combs = new ArrayList<List<Integer>>();
    comb = new ArrayList<Integer>();
    dfs(k, n, 0);
    return combs;
  }
  private void dfs(int k, int n, int last) {
    // do not have enough nums to pick
    if (last + k > 9) return;

    int min = (last + 1 + last + k) * k / 2;
    if (n < min) return;
    if (n == min) {
      ArrayList<Integer> found = new ArrayList<>(comb);
      for (int i=last+1; i<=last+k; i++) found.add(i);
      combs.add(found);
      return;
    }

    int max = (9 - k + 1 + 9) * k / 2;
    if (n == max) {
      ArrayList<Integer> found = new ArrayList<>(comb);
      for (int i=9-k+1; i<=9; i++) found.add(i);
      combs.add(found);
      return;
    }
    if (n > max) return;

    for (int i=last+1; i<9-k+1; i++) {
      comb.add(i);
      dfs(k-1, n-i, i);
      comb.remove(comb.size() - 1);
    }
  }
}

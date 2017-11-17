// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// For example,
// If n = 4 and k = 2, a solution is:

// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

// solution1: backtracking, treat it as a tree,
// we are trying to get all leafs of the tree
// NOTE: use two constrains (may be redundent) is sometimes simpler
// to reason about
// n = 5
// k = 3
// 1
//   2
//     3
//     4
//     5
//   3
//     4
//     5

import java.util.List;
import java.util.ArrayList;

class Solution {
  // public List<List<Integer>> combine(int n, int k) {
  //   List<List<Integer>> combs = new ArrayList<>();
  //   dfs(combs, new ArrayList<Integer>(), 1, n - k + 1, k);
  //   return combs;
  // }
  // public void dfs(List<List<Integer>> combs, List<Integer> comb, int from, int to, int k) {
  //   if (k == 0) {
  //     combs.add(new ArrayList<Integer>(comb));
  //     return;
  //   }

  //   for (int i=from; i<=to; i++) {
  //     comb.add(i);
  //     dfs(combs, comb, i+1, to+1, k-1);
  //     comb.remove(comb.size() - 1);
  //   }
  // }
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
}

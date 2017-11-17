// Given a collection of candidate numbers (C) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
//
//
// Each number in C may only be used once in the combination.
//
// Note:
//
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
//
//
//
//
// For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
// A solution set is:
// [
// [1, 7],
// [1, 2, 5],
// [2, 6],
// [1, 1, 6]
// ]


// https://leetcode.com/problems/combination-sum-ii

// solution1: dfs + backtracking

import java.util.*;
class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (target == 0 || candidates.length == 0) return new ArrayList<>();

    Arrays.sort(candidates);
    List<List<Integer>> combos = new ArrayList<>();
    List<Integer> combo = new ArrayList<>();
    dfs(candidates, target, combos, combo, -1);
    return combos;
  }
  private void dfs(int[] candidates, int target, List<List<Integer>> combos, List<Integer> combo, int index) {
    if (target == 0) {
      combos.add(new ArrayList<Integer>(combo));
      return;
    }

    for (int i = index+1; i < candidates.length; i++) {
      if (target < candidates[i]) {
        return;
      }
      if (i == index + 1 || candidates[i] != candidates[i-1]) {
        combo.add(candidates[i]);
        dfs(candidates, target - candidates[i], combos, combo, i);
        combo.remove(combo.size() - 1);
      }
    }
  }
}

// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

import java.util.*;

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> sets = new ArrayList<>();
    dfs(sets, new ArrayList<Integer>(), nums, 0, nums.length - 1);
    return sets;
  }
  private void dfs (List<List<Integer>> sets, List<Integer> set, int[] nums, int start, int end) {
    sets.add(new ArrayList<Integer>(set));
    for (int i=start; i<=end; i++) {
      set.add(nums[i]);
      dfs(sets, set, nums, i + 1, end);
      set.remove(set.size() - 1);
    }
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

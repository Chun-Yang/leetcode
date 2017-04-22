import java.util.List;
import java.util.ArrayList;

public class Solution {
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

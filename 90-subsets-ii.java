import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> subsets = new ArrayList<>();
    dfs(nums, nums.length, 0, new ArrayList<>(), subsets);
    System.out.println(subsets);
    return subsets;
  }

  private void dfs(int[] nums, int length, int index, ArrayList<Integer> subset, List<List<Integer>> subsets) {
    subsets.add(new ArrayList<>(subset));
    for (int i=index; i<length; i++) {
      if (i == index || nums[i] != nums[i-1]) {
        ArrayList<Integer> newSubset = new ArrayList<>(subset);
        newSubset.add(nums[i]);
        dfs(nums, length, i + 1, newSubset, subsets);
      }
    }
  }
  // public List<List<Integer>> subsetsWithDup(int[] nums) {
  //   HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
  //   for (int num : nums) counter.put(num, counter.getOrDefault(num, 0) + 1);

  //   List<List<Integer>> subsets = new ArrayList<List<Integer>>();
  //   subsets.add(new ArrayList<Integer>());

  //   for (Integer key: counter.keySet()) {
  //     List<List<Integer>> newSubsets = new ArrayList<List<Integer>>();
  //     List<Integer> newNums = new ArrayList<Integer>();
  //     for (int i=1; i<=counter.get(key); i++) {
  //       newNums.add(key);
  //       for (List<Integer> set: subsets) {
  //         List<Integer> newSubset = new ArrayList<Integer>(set);
  //         newSubset.addAll(newNums);
  //         newSubsets.add(newSubset);
  //       }
  //     }
  //     subsets.addAll(newSubsets);
  //   }

  //   return subsets;
  // }
  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.subsetsWithDup(new int[] {1}).equals(Arrays.asList(
          Arrays.asList(),
          Arrays.asList(1)
          ));
    assert s.subsetsWithDup(new int[] {1, 2, 2}).equals(Arrays.asList(
          Arrays.asList(),
          Arrays.asList(1),
          Arrays.asList(1, 2),
          Arrays.asList(1, 2, 2),
          Arrays.asList(2),
          Arrays.asList(2, 2)
          ));
  }
}

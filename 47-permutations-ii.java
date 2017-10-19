// Given a collection of numbers that might contain duplicates,
// return all possible unique permutations.
//
//
//
// For example,
// [1,1,2] have the following unique permutations:
// [
// [1,1,2],
// [1,2,1],
// [2,1,1]
// ]


// https://leetcode.com/problems/permutations-ii

// https://discuss.leetcode.com/topic/32976/9-line-python-solution-with-1-line-to-handle-duplication-beat-99-of-others/8

// solution1: insert new number at all positions, do not add number
// after the same number

import java.util.*;
class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    ArrayList<List<Integer>> perms = new ArrayList<>();
    perms.add(new ArrayList<Integer>());

    for (int i=0; i<nums.length; i++) {
      ArrayList<List<Integer>> nextPerms = new ArrayList<>();
      for (List<Integer> perm : perms) {
        // i is the perm size
        for (int k=0; k<=i; k++) {
          ArrayList<Integer> nextPerm = new ArrayList<>(perm);
          nextPerm.add(k, nums[i]);
          nextPerms.add(nextPerm);
          if (k != i && nums[i] == perm.get(k)) {
            break;
          }
        }
      }
      perms = nextPerms;
    }

    return perms;
  }
}

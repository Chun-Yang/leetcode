// Given an array S of n integers, are there elements a, b, c in S such that
// a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
//
// Note: The solution set must not contain duplicate triplets.
//
// For example, given array S = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
// [-1, 0, 1],
// [-1, -1, 2]
// ]


// https://leetcode.com/problems/3sum

import java.util.*;

// Solution1: sort and two pointer
// time: O(n^2) space: O(# of result)
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> triplets = new ArrayList<List<Integer>>();
    for (int i=0; i<nums.length - 2; i++) {
      if (i !=0 && nums[i] == nums[i-1]) continue;
      int lo = i+1;
      int hi = nums.length - 1;
      while (lo < hi) {
        if (lo != i+1 && nums[lo] == nums[lo - 1]) {
          lo++;
        } else if (hi != nums.length - 1 && nums[hi] == nums[hi + 1]) {
          hi--;
        } else if (nums[i] + nums[lo] + nums[hi] < 0) {
          lo++;
        } else if (nums[i] + nums[lo] + nums[hi] > 0) {
          hi--;
        } else {
          triplets.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
          lo++;
          hi--;
        }
      }
    }
    return triplets;
  }
}

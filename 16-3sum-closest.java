// Given an array S of n integers, find three integers in S such that the sum
// is closest to a given number, target. Return the sum of the three integers.
// You may assume that each input would have exactly one solution.
//
// For example, given array S = {-1 2 1 -4}, and target = 1.
//
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


// https://leetcode.com/problems/3sum-closest

import java.util.*;

// Solution1: sort and two pointers
// time: O(n ^ 2) space: O(1)
class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int closest = nums[0] + nums[1] + nums[2];
    Arrays.sort(nums);
    int sum;
    for (int i=0; i<nums.length - 2; i++) {
      int lo = i+1;
      int hi = nums.length - 1;
      while (lo < hi) {
        sum = nums[i] + nums[lo] + nums[hi];
        if (Math.abs(target - closest) > Math.abs(target - sum)) {
          closest = sum;
        }
        if (target > sum) lo++;
        else if (target < sum) hi--;
        else return target;
      }
    }
    return closest;
  }
}

// Given an array S of n integers, are there elements a, b, c, and d in S such
// that a + b + c + d = target? Find all unique quadruplets in the array which
// gives the sum of target.
//
// Note: The solution set must not contain duplicate quadruplets.
//
//
// For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
//
// A solution set is:
// [
// [-1,  0, 0, 1],
// [-2, -1, 1, 2],
// [-2,  0, 0, 2]
// ]


// https://leetcode.com/problems/4sum

// solution1: sort and two pointers
// r is the number of results
// time: O(n ^ 3) space: O(r)
class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {

  }
}

// solution2: HashMap, key is the sum of two, value is a list of pairs,
// use a counter to check if the quadruplets is valid
// time: ? space: O(n ^ 2)

// Solution3: generalize to n-sum based on 2 sum
// https://discuss.leetcode.com/topic/22705/python-140ms-beats-100-and-works-for-n-sum-n-2
// time: O(n ^ 3)

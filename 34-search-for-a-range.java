// Given an array of integers sorted in ascending order,
// find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
//
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].


// https://leetcode.com/problems/search-for-a-range

// Solution1: binary search
class Solution {
  public int[] searchRange(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;
    // remove value > target
    while (lo < hi) {
      int mid = lo + (hi - lo + 1) / 2;
      if (nums[mid] > target) {
        hi = mid - 1;
      } else {
        lo = mid;
      }
    }
    int start = lo;

    lo = 0;
    hi = nums.length - 1;
    // remove value < target
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] < target) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    int end = hi;

    if (start > end) return new int[]{ -1, -1 };
    return new int[]{ start, end };
  }
}

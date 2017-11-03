// Follow up for "Find Minimum in Rotated Sorted Array":
// What if duplicates are allowed?
//
// Would this affect the run-time complexity? How and why?
//
//
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// Find the minimum element.
//
// The array may contain duplicates.


// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

// solution1: binary search
class Solution {
  public int findMin(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
      // same
      if (nums[hi] == nums[lo]) {
        lo++;
        // hi--; NOTE: 1, 2, 1
        continue;
      }
      // ascending
      if (nums[hi] > nums[lo]) {
        return nums[lo];
      }
      // has pivot
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] >= nums[lo]) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return nums[lo];
  }
}

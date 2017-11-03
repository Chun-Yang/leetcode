// Suppose an array sorted in ascending order is rotated
// at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// Find the minimum element.
//
// You may assume no duplicate exists in the array.


// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

// solution1: binary search
class Solution {
  public int findMin(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
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

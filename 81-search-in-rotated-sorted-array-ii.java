// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Write a function to determine if a given target is in the array.

// The array may contain duplicates.

// solution1: binary search
// deal with edget case when the nums[lo] == nums[hi], we only move lo
// since this value may be the value we are searching

class Solution {
  public boolean search(int[] nums, int target) {
    if (nums.length == 0) return false;

    int lo = 0, hi = nums.length - 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (target == nums[mid]) return true;

      if (nums[lo] == nums[hi]) {
        lo++;
      } else {
        if (nums[mid] >= nums[lo]) {
          if (target >= nums[lo] && target < nums[mid]) hi = mid;
          else lo = mid + 1;
        } else {
          if (target <= nums[hi] && target > nums[mid]) lo = mid + 1;
          else hi = mid;
        }
      }
    }

    return nums[lo] == target;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

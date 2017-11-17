// Given a sorted array and a target value,
// return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
//
// You may assume no duplicates in the array.
//
//
// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0

// solution1: remove all smaller ones
class Solution {
  // public int searchInsert(int[] nums, int target) {
  //   int lo = 0, mid = 0, hi = nums.length - 1;
  //   while (lo <= hi) {
  //     mid = lo + (hi - lo) / 2;
  //     if (target < nums[mid]) hi = mid - 1;
  //     else if (target > nums[mid]) lo = mid + 1;
  //     else return mid;
  //   }

  //   return lo;
  // }
  public int searchInsert(int[] nums, int target) {
    if (nums.length == 0) return 0;

    int lo = 0, hi = nums.length - 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (target < nums[mid]) hi = mid;
      else if (target > nums[mid]) lo = mid + 1;
      else return mid;
    }

    return nums[lo] >= target ? lo : lo + 1;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

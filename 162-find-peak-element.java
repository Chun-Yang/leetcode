public class Solution {
  // public int findPeakElement(int[] nums) {
  //   int lo = 0;
  //   int hi = nums.length - 1;

  //   while (lo < hi) {
  //     int mid = lo + (hi - lo) / 2;
  //     if (mid == 0) {
  //       return nums[1] > nums[0] ? 1 : 0;
  //     }

  //     if (nums[mid - 1] > nums[mid]) {
  //       hi = mid;
  //     } else if (nums[mid + 1] > nums[mid]) {
  //       lo = mid + 1;
  //     } else {
  //       return mid;
  //     }
  //   }

  //   return lo;
  // }
  public int findPeakElement(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int midPlus = mid + 1;
      if (nums[mid] > nums[midPlus]) {
        hi = mid;
      } else {
        lo = midPlus;
      }
    }

    return lo;
  }
}

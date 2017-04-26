public class Solution {
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

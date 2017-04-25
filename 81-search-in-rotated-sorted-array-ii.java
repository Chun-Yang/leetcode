public class Solution {
  public boolean search(int[] nums, int target) {
    if (nums.length == 0) return false;

    int lo = 0, hi = nums.length - 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (target == nums[mid]) return true;

      if (nums[lo] == nums[hi]) {
        lo++;
      } else if (nums[lo] < nums[hi]) {
        if (target < nums[mid]) hi = mid;
        else lo = mid + 1;
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

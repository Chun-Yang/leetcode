public class Solution {
  public int search(int[] nums, int target) {
    if (nums.length == 0) return -1;

    int lo = 0, hi = nums.length - 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (target == nums[mid]) return mid;
      if (nums[mid] >= nums[lo]) {
        if (target >= nums[lo] && target < nums[mid]) hi = mid;
        else lo = mid + 1;
      } else {
        if (target <= nums[hi] && target > nums[mid]) lo = mid + 1;
        else hi = mid;
      }
    }

    return nums[lo] == target ? lo : -1;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
    s.search(new int[] {1,2,3,4}, 3);
  }
}

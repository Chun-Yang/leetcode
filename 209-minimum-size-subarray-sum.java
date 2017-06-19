public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums.length == 0) return 0;

    int minLength = 0;
    int lo = 0;
    int hi = 0;
    int sum = 0;

    while (true) {
      if (sum < s) {
        if (hi == nums.length) return minLength;
        sum += nums[hi];
        hi++;
      } else {
        minLength = minLength == 0 ? (hi - lo) : Math.min(minLength, hi - lo);
        if (minLength == 1) return 1;
        sum -= nums[lo];
        lo++;
      }
    }
  }
}

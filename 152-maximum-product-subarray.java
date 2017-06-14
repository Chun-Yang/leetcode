public class Solution {
  public int maxProduct(int[] nums) {
    if (nums.length == 1) return nums[0];

    int pos = 1;
    int neg = 1;
    int max = 0;
    for (int num : nums) {
      if (num > 0) {
        pos = Math.max(num, pos * num);
        neg *= num;
      } else if (num < 0) {
        int prePos = pos;
        int preNeg = neg;
        pos = preNeg * num;
        neg = Math.min(num, prePos * num);
      } else {
        pos = 0;
        neg = 0;
      }
      max = Math.max(pos, max);
    }
    return max;
  }
}

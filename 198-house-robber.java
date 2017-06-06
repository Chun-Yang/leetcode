// # current
public class Solution {
  public int rob(int[] nums) {
    int has = 0;
    int hasNot = 0;
    for (int num: nums) {
      int preHas = has;
      has = num + hasNot;
      hasNot = Math.max(preHas, hasNot);
    }
    return Math.max(has, hasNot);
  }
  // public int rob(int[] nums) {
  //   int l = nums.length;
  //   if (l==0) return 0;
  //   int[] has = new int[l];
  //   int[] hasNot = new int[l];
  //   has[0] = nums[0];
  //   for (int i=1; i<l; i++) {
  //     has[i] = nums[i] + hasNot[i-1];
  //     hasNot[i] = Math.max(has[i-1], hasNot[i-1]);
  //   }
  //   return Math.max(has[l-1], hasNot[l-1]);
  // }
}

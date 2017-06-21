public class Solution {
  public int rob(int[] nums) {
    int l = nums.length;
    if (l == 0) return 0;
    if (l == 1) return nums[0];

    int skip;
    int rob;
    int skipNext;
    int robNext;

    // we rob the first one
    skip = 0;
    rob = 0;
    for (int i = 2; i < l - 1; i++) {
      skipNext = Math.max(skip, rob);
      robNext = skip + nums[i];
      skip = skipNext;
      rob = robNext;
    }
    int robFirst = nums[0] + Math.max(skip, rob);

    // we skip the first one
    skip = 0;
    rob = 0;
    for (int i = 1; i < l; i++) {
      skipNext = Math.max(skip, rob);
      robNext = skip + nums[i];
      skip = skipNext;
      rob = robNext;
    }
    int skipFirst = Math.max(skip, rob);

    return Math.max(robFirst, skipFirst);
  }
}

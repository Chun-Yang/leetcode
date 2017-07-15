public class Solution {
  // public int missingNumber(int[] nums) {
  //   int n = nums.length + 1;
  //   int sum = 0;
  //   for (int num : nums) sum += num;
  //   return (n - 1) * n / 2 - sum;
  // }
  public int missingNumber(int[] nums) {
    int m = 0;

    for (int num: nums) m ^= num;
    for (int i=0; i<=nums.length; i++) m^= i;

    return m;
  }
}

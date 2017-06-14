public class Solution {
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int length = nums.length;
    int count = 0;
    for (int i=0; i<length - 2; i++) {
      int j = length - 2;
      int k = length - 1;
      while (j > i) {
        while (nums[i] + nums[j] <= nums[k] && k > j) {
          k--;
        }
        count += k - j;
        j--;
      }
    }
    return count;
  }
}

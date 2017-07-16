// http://www.lintcode.com/en/problem/wiggle-sort/

// Given an unsorted array nums, reorder it in-place such that
// nums[0] <= nums[1] >= nums[2] <= nums[3]....

public class Solution {
  /**
   * @param nums a list of integer
   * @return void
   */
  public void wiggleSort(int[] nums) {
    int n = nums.length;
    for (int i=0; i<n-1; i++) {
      if (i % 2 == 0) {
        if (nums[i] > nums[i+1]) {
          int temp = nums[i];
          nums[i] = nums[i+1];
          nums[i+1] = temp;
        }
      } else {
        if (nums[i] < nums[i+1]) {
          int temp = nums[i];
          nums[i] = nums[i+1];
          nums[i+1] = temp;
        }
      }
    }
  }
}

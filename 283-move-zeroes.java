// Given an array nums, write a function to move all 0's to the end of it while
// maintaining the relative order of the non-zero elements.

// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
// should be [1, 3, 12, 0, 0].

// Note: You must do this in-place without making a copy of the array. Minimize
// the total number of operations.

public class Solution {
  public void moveZeroes(int[] nums) {
    int start = 0;
    int end = 0;
    while (true) {
      if (start == nums.length) return;
      else if (nums[start] != 0) start++;
      else if (end == nums.length) return;
      else if (end <= start) end = start + 1;
      else if (nums[end] == 0) end++;
      else {
        // now nums[start] != 0 && nums[end] == 0
        nums[start] = nums[end];
        nums[end] = 0;
        start++;
        end++;
      }
    }
  }
}

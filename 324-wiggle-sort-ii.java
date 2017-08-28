// Given an unsorted array nums,
// reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

// Example:
// (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
// (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

// Note:
// You may assume all input has valid answer.

// Follow Up:
// Can you do it in O(n) time and/or in-place with O(1) extra space?

import java.util.*;

class Solution {
  public static void main (String[] args) {
    Solution s = new Solution();
    s.wiggleSort(new int[]{ 1,1,2,1,2,2,1 });
    s.wiggleSort(new int[]{ 1,1,2,1,2,2 });
  }
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int[] sorted = new int[nums.length];
    for (int i=0; i<nums.length; i++) {
      int index = i / 2 + ((i % 2 == 0) ? 0 : ((nums.length + 1) / 2));
      sorted[i] = nums[index];
    }
    for (int i=0; i<nums.length; i++) {
      nums[i] = sorted[i];
    }
    System.out.println(Arrays.toString(nums));
  }
}

// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array nums = [1,1,1,2,2,3],

// Your function should return length = 5, with the first five elements of nums
// being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

// solution1: pointers
// one iterator
// one boundary
// 1 1 3
// 1 2 2
class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) return nums.length;
    int length = 2;
    for (int i=2; i<nums.length; i++) {
      if (nums[i] != nums[length-2]) nums[length++]=nums[i];
    }
    return length;
  }
}

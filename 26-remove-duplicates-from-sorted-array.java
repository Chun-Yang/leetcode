// Given a sorted array, remove the duplicates in place such that each element
// appear only once and return the new length.
//
//
// Do not allocate extra space for another array,
// you must do this in place with constant memory.
//
//
//
// For example,
// Given input array nums = [1,1,2],
//
//
// Your function should return length = 2, with the first two elements of nums
// being 1 and 2 respectively. It doesn't matter what you leave beyond the new
// length.


// https://leetcode.com/problems/remove-duplicates-from-sorted-array

// solution1: two pointers
// - first pointer is the length of the sequence
// - second pointer is the number to examine

class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;

    int length = 1;
    for (int i=1; i<nums.length; i++) {
      if (nums[i] > nums[length - 1]) nums[length++] = nums[i];
    }
    return length;
  }
}

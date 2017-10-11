// Given an array and a value, remove all instances of that value in place and return the new length.
//
//
// Do not allocate extra space for another array, you must do this in place with constant memory.
//
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//
//
// Example:
// Given input array nums = [3,2,2,3], val = 3
//
//
// Your function should return length = 2, with the first two elements of nums being 2.


// https://leetcode.com/problems/remove-element

// Solution1: two pointers
// - lo pointer is the end of filtered nums
// - hi pointer is the start of removed nums
class Solution {
  public int removeElement(int[] nums, int val) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo <= hi) {
      if (nums[lo] == val) nums[lo] = nums[hi--];
      else lo++;
    }
    return lo;
  }
}

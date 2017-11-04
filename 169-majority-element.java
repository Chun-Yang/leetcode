// Given an array of size n, find the majority element.
// The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority
// element always exist in the array.

// https://leetcode.com/problems/majority-element

// solution1: one pass +-

class Solution {
  public int majorityElement(int[] nums) {
    int counter = 0;
    int major = 0; // the inital value can be any number
    for (int num : nums) {
      if (num == major) {
        counter++;
      } else {
        counter--;
        if (counter < 0) {
          major = num;
          counter = 1;
        }
      }
    }
    return major;
  }
}

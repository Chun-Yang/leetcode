// Given an array of non-negative integers,
// you are initially positioned at the first index of the array.
//
//
// Each element in the array represents your maximum jump length at that position.
//
//
// Determine if you are able to reach the last index.
//
//
//
// For example:
// A = [2,3,1,1,4], return true.
//
//
// A = [3,2,1,0,4], return false.


// https://leetcode.com/problems/jump-game

// Solution1: two pointers
// class Solution {
//   public boolean canJump(int[] nums) {
//     int end = 0;
//     int nextEnd = 0;

//     for (int i=0; i<nums.length; i++) {
//       nextEnd = Math.max(nextEnd, i + nums[i]);
//       if (nextEnd >= nums.length - 1) return true;
//       if (i == end) {
//         if (end == nextEnd) return false;
//         else end = nextEnd;
//       }
//     }

//     // NOTE: this is never reached
//     return false;
//   }
// }

// Solution2: one pointer
class Solution {
  public boolean canJump(int[] nums) {
    int end = 0;

    for (int i=0; i<nums.length; i++) {
      if (end < i) return false; // can not reach current position
      end = Math.max(end, i + nums[i]);
      if (end >= nums.length - 1) return true; // can reach last position
    }

    // when the length of nums is 0
    return true;
  }
}

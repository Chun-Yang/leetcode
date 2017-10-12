// Given an unsorted integer array, find the first missing positive integer.
//
//
//
// For example,
// [1,2,0] 3
// [3,4,-1,1] 2
// [2,2,3] 1
//
//
//
// Your algorithm should run in O(n) time and uses constant space.
// NOTE: first means


// https://leetcode.com/problems/first-missing-positive

// Solution1:
// two pass:
// pointer jump + change positive to negative
// select the first index whose value is positive
// [1,2,0] [-1,-2,0]

// after processing
// >= 0 means not visited
// -1 means visited

// class Solution {
//   public int firstMissingPositive(int[] nums) {
//     for (int i=0; i<nums.length; i++) {
//       if (nums[i] <= 0) nums[i] = 0;
//     }
//     for (int i=0; i<nums.length; i++) {
//       int index = nums[i] - 1;
//       while(index >= 0 && index < nums.length) {
//         int nextIndex = nums[index] - 1;
//         nums[index] = -1;
//         index = nextIndex;
//       }
//     }
//     for (int i=0; i<nums.length; i++) {
//       if (nums[i] >= 0) return i + 1;
//     }
//     return nums.length + 1;
//   }
// }

// Solution2: move value to its own position
// https://discuss.leetcode.com/topic/1361/a-very-nice-solution-from-ants-aasma-stackoverflow

class Solution {
  public int firstMissingPositive(int[] nums) {
    for (int i=0; i<nums.length; i++) {
      // index [1, n]
      int index = nums[i];
      while(index >= 1 && index <= nums.length && index != nums[index - 1]) {
        int nextIndex = nums[index - 1];
        nums[index - 1] = index;
        index = nextIndex;
      }
    }
    for (int i=0; i<nums.length; i++) {
      if (nums[i] != i + 1) return i + 1;
    }
    return nums.length + 1;
  }
}

// Given an array of non-negative integers, you are initially positioned at the
// first index of the array.
//
//
// Each element in the array represents your maximum jump length at that
// position.
//
//
// Your goal is to reach the last index in the minimum number of jumps.
//
//
//
// For example:
// Given array A = [2,3,1,1,4]
//
//
// The minimum number of jumps to reach the last index is 2.
// (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
//
//
//
// Note:
// You can assume that you can always reach the last index.


// https://leetcode.com/problems/jump-game-ii

// solution1: dp
// time: O(n ^ 2) space: O(n)
// 2 3 1 1 4
// 2 1 2 1 0
// keep track of maxIndex and minStep

// solution2: deque
// time: O(n) space: O(n)

// import java.util.*;
// class Solution {
//   public int jump(int[] nums) {
//     if (nums.length <= 1) return 0;
//     if (nums[0] >= nums.length - 1) return 1;

//     Deque<Integer> steps = new LinkedList<>();
//     steps.offerLast(0);
//     Deque<Integer> indexes = new LinkedList<>();
//     indexes.offerLast(nums[0]);
//     for (int i=1; i<nums.length; i++) {
//       int minStep = steps.peekFirst() + 1;
//       int maxIndex = i + nums[i];
//       if (maxIndex >= nums.length - 1) return minStep + 1;
//       // add current one
//       if (maxIndex > indexes.peekLast()) {
//         steps.offerLast(minStep);
//         indexes.offerLast(maxIndex);
//       }
//       // remove first one
//       while (indexes.peekFirst() == i) {
//         steps.pollFirst();
//         indexes.pollFirst();
//       }
//     }

//     return -1;
//   }

// }

// Solution3: greedy
// time: O(n) space O(1)
// https://discuss.leetcode.com/topic/28470/concise-o-n-one-loop-java-solution-based-on-greedy

class Solution {
  public int jump(int[] nums) {
    int step = 0;
    int endIndex = 0;
    int nextEndIndex = 0;
    for (int i=0; i<nums.length; i++) {
      if (endIndex >= nums.length - 1) return step;

      nextEndIndex = Math.max(nextEndIndex, i + nums[i]);
      if (endIndex == i) {
        step++;
        endIndex = nextEndIndex;
      }
    }
    return step;
  }
}

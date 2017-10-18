// Given an array nums, write a function to move all 0's to the end of it while
// maintaining the relative order of the non-zero elements.

// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
// should be [1, 3, 12, 0, 0].

// Note: You must do this in-place without making a copy of the array. Minimize
// the total number of operations.

class Solution {
  // solution3: optimal assignment
  public void moveZeroes(int[] nums) {
    int startOfZero = 0;
    // If the current element is not 0, then we need to
    // append it just in front of last non 0 element we found.
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        //move non-zeno close to the head
        if (startOfZero != i) nums[startOfZero] = nums[i];
        startOfZero++;
      }
    }
    for (int i=startOfZero; i<nums.length; i++) {
      if (nums[i] != 0) nums[i] = 0;
    }
  }

  // solution2:
  // public void moveZeroes(int[] nums) {
  //   int startOfZero = 0;
  //   for (int i=0; i<nums.length; i++) {
  //     if (nums[i] != 0) {
  //       int temp = nums[startOfZero];
  //       nums[startOfZero] = nums[i];
  //       nums[i] = temp;
  //       startOfZero++;
  //     }
  //   }
  // }

  // solution1:
  // public void moveZeroes(int[] nums) {
  //   int start = 0;
  //   int end = 0;
  //   while (true) {
  //     if (start == nums.length) return;
  //     else if (nums[start] != 0) start++;
  //     else if (end == nums.length) return;
  //     else if (end <= start) end = start + 1;
  //     else if (nums[end] == 0) end++;
  //     else {
  //       // now nums[start] != 0 && nums[end] == 0
  //       nums[start] = nums[end];
  //       nums[end] = 0;
  //       start++;
  //       end++;
  //     }
  //   }
  // }

}

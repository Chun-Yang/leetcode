// Given an array of integers with possible duplicates, randomly output the
// index of a given target number. You can assume that the given target number
// must exist in the array.

// Note:
// The array size can be very large. Solution that uses too much extra space
// will not pass the judge.

// Example:

// int[] nums = new int[] {1,2,3,3,3};
// Solution solution = new Solution(nums);

// // pick(3) should return either index 2, 3, or 4 randomly. Each index should
// have equal probability of returning.
// solution.pick(3);

// // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
// solution.pick(1);

// solution1: HashMap + ArrayList : key is num, values are indexes
// solution2: Sort and record indexes using another array
// Solution3: O(n) pick, reservoir sampling

class Solution {
  int[] nums;

  public Solution(int[] nums) {
    this.nums = nums;
  }

  public int pick(int target) {
    int index = -1;
    int count = 0;

    for (int i=0; i<nums.length; i++) {
      if (nums[i] == target) {
        count++;
        if (Math.random() < (1.0 / count)) index = i;
      }
    }


    return index;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

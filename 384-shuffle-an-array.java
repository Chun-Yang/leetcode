// Shuffle a set of numbers without duplicates.

// Example:

// // Init an array with set 1, 2, and 3.
// int[] nums = {1,2,3};
// Solution solution = new Solution(nums);

// // Shuffle the array [1,2,3] and return its result. Any permutation of
// [1,2,3] must equally likely to be returned.
// solution.shuffle();

// // Resets the array back to its original configuration [1,2,3].
// solution.reset();

// // Returns the random shuffling of array [1,2,3].
// solution.shuffle();

// Solution: this is similar to reservoir sampling
class Solution {
  private int[] nums;

  public Solution(int[] nums) {
    this.nums = nums;
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return nums;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int[] shuffled = new int[nums.length];
    for (int i=0; i<nums.length; i++) {
      int chosen = (int)(Math.random() * (i + 1));
      shuffled[i] = shuffled[chosen];
      shuffled[chosen] = nums[i];
    }
    return shuffled;
  }
}

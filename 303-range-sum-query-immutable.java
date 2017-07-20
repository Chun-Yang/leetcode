// Given an integer array nums, find the sum of the elements between indices i
// and j (i ≤ j), inclusive.

// Example:
// Given nums = [-2, 0, 3, -5, 2, -1]

// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3
// Note:
// You may assume that the array does not change.
// There are many calls to sumRange function.

public class NumArray {
  int[] prefixes;

  public NumArray(int[] nums) {
    prefixes = new int[nums.length + 1];
    for (int i=1; i<=nums.length; i++) {
      prefixes[i] = prefixes[i-1] + nums[i-1];
    }
  }

  public int sumRange(int i, int j) {
    return prefixes[j+1] - prefixes[i];
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

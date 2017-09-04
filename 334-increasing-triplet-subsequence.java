// Given an unsorted array return whether an increasing subsequence of length 3
// exists or not in the array.

// Formally the function should:
// Return true if there exists i, j, k
// such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
// Your algorithm should run in O(n) time complexity and O(1) space complexity.

// Examples:
// Given [1, 2, 3, 4, 5],
// return true.

// Given [5, 4, 3, 2, 1],
// return false.

// NOTE: the following solution is not O(1) space, we need a O(1) space
class Solution {
  public boolean increasingTriplet(int[] nums) {
    if (nums.length < 3) return false;

    int[] minPrefix = new int[nums.length];
    int min = Integer.MAX_VALUE;
    for (int i=1; i<nums.length-1; i++) {
      min = Math.min(nums[i-1], min);
      minPrefix[i] = min;
    }

    int[] maxSuffix = new int[nums.length];
    int max = Integer.MIN_VALUE;
    for (int i=nums.length-2; i>0; i--) {
      max = Math.max(nums[i+1], max);
      maxSuffix[i] = max;
    }

    for (int i=1; i<nums.length-1; i++) {
      if (nums[i] > minPrefix[i] && nums[i] < maxSuffix[i]) return true;
    }
    return false;
  }
}

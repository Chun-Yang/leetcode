// Given an array nums and a target value k, find the maximum length of a subarray
// that sums to k. If there isn't one, return 0 instead.

// Example 1:
// Given nums = [1, -1, 5, -2, 3], k = 3,
// return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
// Example 2:
// Given nums = [-2, -1, 2, 1], k = 1,
// return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
// Follow Up:
// Can you do it in O(n) time?

import java.util.*;

class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
    // {[number]: [index]}
    HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
    prefixSumMap.put(0, 0);
    int prefixSum = 0;

    int length = 0;
    for (int i=0; i<nums.length; i++) {
      // check if we can find a valid subarray
      prefixSum += nums[i];
      if (prefixSumMap.containsKey(prefixSum - k)) {
        length = Math.max(length, i + 1 - prefixSumMap.get(prefixSum - k));
      }
      if (!prefixSumMap.containsKey(prefixSum)) {
        prefixSumMap.put(prefixSum, i);
      }
    }
    return length;
  }
}

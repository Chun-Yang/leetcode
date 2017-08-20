// Given an unsorted array of integers, find the length of longest increasing
// subsequence.

// For example,
// Given [10, 9, 2, 5, 3, 7, 101, 18],
// The longest increasing subsequence is [2, 3, 7, 101], therefore the length is
// 4. Note that there may be more than one LIS combination, it is only necessary
// for you to return the length.

// Your algorithm should run in O(n2) complexity.

// Follow up: Could you improve it to O(n log n) time complexity?

public class Solution {
  public int lengthOfLIS(int[] nums) {
    int[] mins = new int[nums.length];
    int size = 0;
    for (int num : nums) {
      int lo = 0;
      int hi = size;
      // find the first number that is larger than itself
      while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (num > mins[mid]) lo = mid + 1;
        else hi = mid;
      }
      mins[lo] = num;
      if (lo == size) size++;
    }
    return size;
  }

}

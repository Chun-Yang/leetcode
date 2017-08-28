// Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
// Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j, inclusive.

// Note:
// A naive algorithm of O(n2) is trivial. You MUST do better than that.

// Example:
// Given nums = [-2, 5, -1], lower = -2, upper = 2,
// Return 3.
// The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.


import java.util.*;

// Solution: BST
// NOTE: we can simplify the logic by calculating the numbers that is smaller and larger than the range
// https://discuss.leetcode.com/topic/34107/java-bst-solution-averagely-o-nlogn
class Solution {
  class Node {
    long val;
    int leftCount;
    int currentCount;
    int rightCount;
    Node left;
    Node right;
    public Node(long val) {
      this.val = val;
      leftCount = 0;
      currentCount = 1;
      rightCount = 0;
    }
  }
  public int countRangeSum(int[] nums, int lower, int upper) {
    int l = nums.length;

    // calculate prefix sums (inclusive)
    long[] prefixSums = new long[l];
    long prefixSum = 0;
    for (int i=0; i<l; i++) {
      prefixSum += nums[i];
      prefixSums[i] = prefixSum;
    }

    // calculate sum
    int sum = 0;

    Node bst = new Node(0);

    for (int i=0; i<l; i++) {
      sum += count(
        bst,
        prefixSums[i] - (long)upper,
        prefixSums[i] - (long)lower,
        Long.MIN_VALUE,
        Long.MAX_VALUE
      );
      bst = insert(bst, prefixSums[i]);
    }

    return sum;
  }
  private int count(Node node, long lower, long upper, long parentLower, long parentUpper) {
    if (node == null || parentUpper < lower || parentLower > upper) return 0;
    if (node.val < lower) return count(node.right, lower, upper, Math.min(parentLower, node.val), parentUpper);
    if (node.val > upper) return count(node.left, lower, upper, parentLower, Math.min(parentUpper, node.val));

    // node.val is in between lower and upper
    int totalCount = node.currentCount;

    if (parentUpper <= upper) totalCount += node.rightCount;
    else totalCount += count(node.right, lower, upper, Math.min(parentLower, node.val), parentUpper);

    if (parentLower >= lower) totalCount += node.leftCount;
    else totalCount += count(node.left, lower, upper, parentLower, Math.min(parentUpper, node.val));

    return totalCount;
  }
  private Node insert(Node node, long val) {
    if (node == null) return new Node(val);

    if (val < node.val) {
      node.left = insert(node.left, val);
      node.leftCount++;
    } else if (val > node.val) {
      node.right = insert(node.right, val);
      node.rightCount++;
    } else {
      node.currentCount++;
    }
    return node;
  }
}


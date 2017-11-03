// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
//
//
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.


// https://leetcode.com/problems/maximum-product-subarray

// solution1: dp
// for each number, find the max product that ends with it
// - min
// - max
// - maxProduct

class Solution {
  public int maxProduct(int[] nums) {
    int min = 1;
    int max = 1;
    int product = Integer.MIN_VALUE;
    int nextMin;
    int nextMax;
    for (int num : nums) {
      nextMin = Math.min(num, Math.min(min * num, max * num));
      nextMax = Math.max(num, Math.max(min * num, max * num));
      min = nextMin;
      max = nextMax;
      product = Math.max(max, product);
    }
    return product;
  }
}

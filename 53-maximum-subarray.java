// Find the contiguous subarray within an array (containing at least one number)
// which has the largest sum.

// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6.

// explanation: two pointer / dp, always get largest sum that ends with i
// max = Math.max(previousMax, 0) + nums[i]
class Solution {
  public int maxSubArray(int[] nums) {
    int sum = nums[0];
    int maxSum = sum;
    for (int i=1; i<nums.length; i++) {
      if (sum < 0) sum = nums[i];
      else sum += nums[i];
      maxSum = Math.max(sum, maxSum);
    }
    return maxSum;
  }
}

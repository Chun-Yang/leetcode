// Find the contiguous subarray within an array (containing at least one number)
// which has the largest product.

// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.


























// Solution 2 dp
// https://discuss.leetcode.com/topic/4417/possibly-simplest-solution-with-o-n-time-complexity

// Solution 1
class Solution {
  public int maxProduct(int[] nums) {
    boolean hasZero = false;
    for (int num : nums) {
      if (num == 0) {
        hasZero = true;
        break;
      }
    }

    int max = Integer.MIN_VALUE;
    int positive = 0;
    int negative = 0;
    for (int num : nums) {
      if (num > 0) {
        positive = positive == 0 ? num : positive * num;
        negative = negative * num;
        max = Math.max(positive, max);
      } else if (num < 0) {
        int prePositive = positive;
        int preNegative = negative;
        positive = preNegative * num;
        negative = prePositive == 0 ? num : prePositive * num;
        if (positive == 0) max = Math.max(negative, max);
        else max = Math.max(positive, max);
      } else {
        positive = 0;
        negative = 0;
      }
    }
    return hasZero ? Math.max(max, 0) : max;
  }
}

// public class Solution {
//   public int maxProduct(int[] nums) {
//     if (nums.length == 1) return nums[0];

//     int pos = 1;
//     int neg = 1;
//     int max = 0;
//     for (int num : nums) {
//       if (num > 0) {
//         pos = Math.max(num, pos * num);
//         neg *= num;
//       } else if (num < 0) {
//         int prePos = pos;
//         int preNeg = neg;
//         pos = preNeg * num;
//         neg = Math.min(num, prePos * num);
//       } else {
//         pos = 0;
//         neg = 0;
//       }
//       max = Math.max(pos, max);
//     }
//     return max;
//   }
// }

// Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number
// on it represented by array nums. You are asked to burst all the balloons. If
// the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
// Here left and right are adjacent indices of i. After the burst, the left and
// right then becomes adjacent.

// Find the maximum coins you can collect by bursting the balloons wisely.

// Note:
// (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can
// not burst them.
// (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

// Example:

// Given [3, 1, 5, 8]

// Return 167

//     nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

// Solution 2: use int[][] as cache

// Solution 1: use HashMap as cache
// public class Solution {
//   static public void main(String[] args) {
//     Solution s = new Solution();
//     s.maxCoins(new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5});
//   }
//   HashMap<String, Integer> cache;
//   public int maxCoins(int[] nums) {
//     cache = new HashMap<>();
//     return max(nums, 1, 1, 0, nums.length - 1);
//   }
//   private int max(int[] nums, int lb, int rb, int start, int end) {
//     if (start > end) return 0;
//     if (start == end) return lb * nums[start] * rb;

//     String key = lb + " " + rb + " " + start + " " + end;
//     if (cache.containsKey(key)) return cache.get(key);

//     int m = 0;
//     for (int i=start; i<=end; i++) {
//       int coins = max(nums, lb, nums[i], start, i - 1)
//         + max(nums, nums[i], rb, i + 1, end)
//         + lb * nums[i] * rb;
//       m = Math.max(m, coins);
//     }

//     cache.put(key, m);

//     return m;
//   }
// }

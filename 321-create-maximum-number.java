// Given two arrays of length m and n with digits 0-9 representing
// two numbers. Create the maximum number of length k <= m + n
// from digits of the two. The relative order of the digits from
// the same array must be preserved. Return an array of the k
// digits. You should try to optimize your time and space
// complexity.

// Example 1:
// nums1 = [3, 4, 6, 5]
// nums2 = [9, 1, 2, 5, 8, 3]
// k = 5
// return [9, 8, 6, 5, 3]

// Example 2:
// nums1 = [6, 7]
// nums2 = [6, 0, 4]
// k = 5
// return [6, 7, 6, 0, 4]

// Example 3:
// nums1 = [3, 9]
// nums2 = [8, 9]
// k = 3
// return [9, 8, 9]

import java.util.*;

class Solution {
  public static void main (String[] args) {
    Solution s = new Solution();
    s.maxNumber(
        new int[]{6,7},
        new int[]{6,0,4},
        5
        );
  }

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
  }
}


// failed attempt: the merge is incorrect
// import java.util.*;

// class Solution {
//   public static void main (String[] args) {
//     Solution s = new Solution();
//     s.maxNumber(
//         new int[]{6,5,4,6,3,7,5,6,4,5,6,4},
//         new int[]{8,8,6,0},
//         16
//         );
//   }

//   public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//     int[][] maxes1 = getMaxes(nums1, k);
//     int[][] maxes2 = getMaxes(nums2, k);
//     int[] maxCombo = new int[k];
//     for (int l1=Math.max(0, k-nums2.length); l1<=Math.min(nums1.length, k); l1++) {
//       int l2 = k - l1;
//       int i1=0;
//       int i2=0;
//       int[] candidate = new int[k];
//       while (i1 + i2 < k) {
//         System.out.println("i1", i1);
//         if (i1 == l1) {
//           candidate[i1+i2] = maxes2[l2][i2];
//           i2++;
//         } else if (i2 == l2) {
//           candidate[i1+i2] = maxes1[l1][i1];
//           i1++;
//         } else if(maxes2[l1][i1] > maxes2[l2][i2]) {
//           candidate[i1+i2] = maxes1[l1][i1];
//           i1++;
//         } else {
//           candidate[i1+i2] = maxes2[l2][i2];
//           i2++;
//         }
//       }
//       if (larger(candidate, maxCombo, k)) maxCombo = candidate;
//     }

//     return maxCombo;
//     // check combinations of the two combinations
//   }
//   private int[][] getMaxes(int[] nums, int k) {
//     int n = nums.length;
//     int nk = Math.min(nums.length, k);
//     // max combinations by length
//     int[][] maxes = new int[nk + 1][nk];
//     // l is the length
//     for (int i=0; i<n; i++) {
//       for (int l=Math.min(nk, i+1); l>=1; l--) {
//         int[] candidate = maxes[l-1];
//         int origin = candidate[l-1];
//         candidate[l-1] = nums[i];
//         if (larger(candidate, maxes[l], l)) {
//           for (int j=0; j<l; j++) maxes[l][j] = candidate[j];
//         }
//         candidate[l-1] = origin;
//       }
//     }
//     return maxes;
//   }
//   private boolean larger(int[] x, int[] y, int length) {
//     for (int i=0; i<length; i++) {
//       if (x[i] > y[i]) return true;
//     }
//     return false;
//   }
// }

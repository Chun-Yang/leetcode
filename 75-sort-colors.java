// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note:
// You are not suppose to use the library's sort function for this problem.

// click to show follow up.

// Follow up:
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

// Could you come up with an one-pass algorithm using only constant space?
// https://discuss.leetcode.com/topic/6968/four-different-solutions/2

// import java.util.Arrays;

class Solution {
  // swap
  // NOTE: the indexes are exclusive boundaries
  // public void sortColors(int[] nums) {
  //   int zero=0, one=0, two=nums.length - 1;
  //   while (one <= two) {
  //     if (nums[one] == 2) {
  //       nums[one] = nums[two];
  //       nums[two--] = 2;
  //     } else if (nums[one] == 0) {
  //       nums[one++] = nums[zero];
  //       nums[zero++] = 0;
  //     } else {
  //       one++;
  //     }
  //   }
  // }

  public void sortColors(int[] nums) {
    int zeroEnd=0, oneEnd=0, twoStart=nums.length;
    while (oneEnd < twoStart) {
      if (nums[oneEnd] == 2) {
        twoStart--;
        nums[oneEnd] = nums[twoStart];
        nums[twoStart] = 2;
      } else if (nums[oneEnd] == 0) {
        nums[oneEnd] = nums[zeroEnd];
        nums[zeroEnd] = 0;
        oneEnd++;
        zeroEnd++;
      } else {
        oneEnd++;
      }
    }
  }

  // BUCKET SORT
  // public void sortColors(int[] nums) {
  //   int[] counts = new int[3];
  //   for (int num : nums) {
  //     counts[num]++;
  //   }
  //   for (int i=0,k=0; i<3; i++) {
  //     for (int j=0; j<counts[i]; j++) {
  //       nums[k++] = i;
  //     }
  //   }
  // }

  // // ORIGINAL
  // // THIS IS NOT ONE PASS
  // public void sortColors(int[] nums) {
  //   int zero = 0;
  //   int one = 0;
  //   int two = nums.length - 1;
  //   while (one <= two) {
  //     if (nums[zero] == 0) {
  //       zero++;
  //       one = Math.max(zero, one);
  //     } else if (nums[two] == 2) {
  //       two--;
  //     } else if (nums[one] == 1) {
  //       one++;
  //     } else if (nums[one] == 0) {
  //       nums[one] = nums[zero];
  //       nums[zero] = 0;
  //       zero++;
  //       one++;
  //     } else if (nums[two] == 1) {
  //       nums[one] = 1;
  //       nums[two] = 2;
  //       one++;
  //       two--;
  //     } else if (nums[two] == 0) {
  //       nums[zero] = 0;
  //       if (one > zero) nums[one] = 1;
  //       nums[two] = 2;
  //       zero++;
  //       one++;
  //       two--;
  //     } else {
  //       throw new Error("Unexpected condition");
  //     }
  //   }
  // }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

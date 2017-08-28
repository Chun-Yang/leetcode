// https://discuss.leetcode.com/topic/6968/four-different-solutions/2
// import java.util.Arrays;

public class Solution {
  // swap
  // NOTE: the indexes are exclusive boundaries
  public void sortColors(int[] nums) {
    int zero=0, one=0, two=nums.length - 1;
    while (one <= two) {
      if (nums[one] == 2) {
        nums[one] = nums[two];
        nums[two--] = 2;
      } else if (nums[one] == 0) {
        nums[one++] = nums[zero];
        nums[zero++] = 0;
      } else {
        one++;
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

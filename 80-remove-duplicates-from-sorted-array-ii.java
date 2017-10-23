// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array nums = [1,1,1,2,2,3],

// Your function should return length = 5, with the first five elements of nums
// being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

class Solution {
  // public int removeDuplicates(int[] nums) {
  //   if (nums.length == 0) return 0;

  //   int validTill = 0;
  //   int count = 1;
  //   for (int i=1; i<nums.length; i++) {
  //     if (nums[i] != nums[validTill]) {
  //       nums[++validTill] = nums[i];
  //       count = 1;
  //     } else if (count < 2) {
  //       nums[++validTill] = nums[i];
  //       count++;
  //     }
  //   }
  //   return validTill + 1;
  // }
  public int removeDuplicates(int[] nums) {
    int length = 0;
    for (int num: nums) {
      if (length < 2 || num != nums[length - 2]) {
        nums[length++] = num;
      }
    }
    return length;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

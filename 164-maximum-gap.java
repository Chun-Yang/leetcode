public class Solution {
  public int maximumGap(int[] nums) {
    int length = nums.length;
    if (length < 2) return 0;

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int num: nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }

    int width = (int)Math.ceil((double)(max - min) / (length - 1));
    if (width == 0) return 0;

    int[] lefts = new int[length];
    int[] rights = new int[length];
    Arrays.fill(lefts, Integer.MAX_VALUE);
    Arrays.fill(rights, Integer.MIN_VALUE);
    for (int num: nums) {
      int index = (num - min) / width;
      lefts[index] = Math.min(lefts[index], num);
      rights[index] = Math.max(rights[index], num);
    }

    int pre = rights[0];
    int gap = 0;
    for (int i=1; i < length; i++) {
      if (lefts[i] != Integer.MAX_VALUE) {
        gap = Math.max(gap, lefts[i] - pre);
        pre = rights[i];
      }
    }

    return gap;
  }
}

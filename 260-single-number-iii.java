public class Solution {
  public int[] singleNumber(int[] nums) {
    int combined = 0;
    for (int num : nums) combined ^= num;
    // another way to get mask:
    // mask = combined & -combined;
    int mask = 1;
    while ((combined & mask) == 0) mask <<= 1;

    int first = 0;
    int second = 0;
    for (int num : nums) {
      if ((mask & num) == 0) {
        first ^= num;
      } else {
        second ^= num;
      }
    }
    return new int[]{ first, second };
  }
}

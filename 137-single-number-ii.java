public class Solution {
  public int singleNumber(int[] nums) {
    int single = 0;

    for (int i=31; i>=0; i--) {
      int digit = 0;
      for (int num: nums) {
        digit += (num >> i) & 1;
      }
      single = (single << 1) + (digit % 3);
    }

    return single;
  }
}

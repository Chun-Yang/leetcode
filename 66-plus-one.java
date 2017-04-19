import java.util.Arrays;

public class Solution {
  public int[] plusOne(int[] digits) {
    int n = digits.length;
    int carry = 1;
    int[] increased = digits.clone();
    for (int i = n-1; i >= 0; i--) {
      increased[i] = (digits[i] + carry) % 10;
      carry = (digits[i] + carry) / 10;
      if (carry == 0) return increased;
    }
    int[] extra = new int[n + 1];
    extra[0] = 1;
    for (int i=1; i<n; i++) {
      extra[i] = increased[i];
    }
    return extra;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    assert Arrays.equals(s.plusOne(new int[] {0}), new int[] {1});
    assert Arrays.equals(s.plusOne(new int[] {8}), new int[] {9});
    assert Arrays.equals(s.plusOne(new int[] {9}), new int[] {1, 0});
    assert Arrays.equals(s.plusOne(new int[] {1, 0}), new int[] {1, 1});
    assert Arrays.equals(s.plusOne(new int[] {1, 9}), new int[] {2, 0});
    assert Arrays.equals(s.plusOne(new int[] {9, 9}), new int[] {1, 0, 0});
  }
}

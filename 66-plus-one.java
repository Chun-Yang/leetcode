// Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

// You may assume the integer do not contain any leading zero, except the number 0 itself.

// The digits are stored such that the most significant digit is at the head of the list.
import java.util.Arrays;

// inplace: https://discuss.leetcode.com/topic/24288/my-simple-java-solution/5
class Solution {
  public int[] plusOne(int[] digits) {
    int indexToChange = digits.length - 1;
    while (indexToChange >= 0 && digits[indexToChange] == 9) {
      indexToChange--;
    }

    if (indexToChange == -1) {
      int[] nextDigits = new int[digits.length + 1];
      nextDigits[0] = 1;
      return nextDigits;
    } else {
      int[] nextDigits = digits.clone();
      nextDigits[indexToChange]++;
      for (int i = indexToChange + 1; i < digits.length; i++) nextDigits[i] = 0;
      return nextDigits;
    }
  }
}

// public class Solution {
//   public int[] plusOne(int[] digits) {
//     int n = digits.length;
//     int carry = 1;
//     int[] increased = digits.clone();
//     for (int i = n-1; i >= 0; i--) {
//       increased[i] = (digits[i] + carry) % 10;
//       carry = (digits[i] + carry) / 10;
//       if (carry == 0) return increased;
//     }
//     int[] extra = new int[n + 1];
//     extra[0] = 1;
//     for (int i=1; i<n; i++) {
//       extra[i] = increased[i];
//     }
//     return extra;
//   }

//   public static void main (String[] args) {
//     Solution s = new Solution();
//     assert Arrays.equals(s.plusOne(new int[] {0}), new int[] {1});
//     assert Arrays.equals(s.plusOne(new int[] {8}), new int[] {9});
//     assert Arrays.equals(s.plusOne(new int[] {9}), new int[] {1, 0});
//     assert Arrays.equals(s.plusOne(new int[] {1, 0}), new int[] {1, 1});
//     assert Arrays.equals(s.plusOne(new int[] {1, 9}), new int[] {2, 0});
//     assert Arrays.equals(s.plusOne(new int[] {9, 9}), new int[] {1, 0, 0});
//   }
// }

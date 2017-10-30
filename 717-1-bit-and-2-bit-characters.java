// We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

// Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

// Example 1:
// Input:
// bits = [1, 0, 0]
// Output: True
// Explanation:
// The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
// Example 2:
// Input:
// bits = [1, 1, 1, 0]
// Output: False
// Explanation:
// The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
// Note:

// 1 <= len(bits) <= 1000.
// bits[i] is always 0 or 1.

// solution1: dp
class Solution {
  public boolean isOneBitCharacter(int[] bits) {
    int n = bits.length;
    if (n == 1) {
      return true;
    }
    boolean[] ones = new boolean[n];
    boolean[] twos = new boolean[n];
    ones[0] = bits[0] == 0;
    ones[1] = bits[1] == 0 && bits[0] == 0;
    twos[1] = bits[0] == 1;

    for (int i=2; i<n; i++) {
      ones[i] = bits[i] == 0 && (ones[i-1] || twos[i-1]);
      twos[i] = bits[i-1] == 1 && (ones[i-2] || twos[i-2]);
    }

    return ones[n-1];
  }
}

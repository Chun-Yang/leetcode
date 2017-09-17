// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

// Example:
// Given a = 1 and b = 2, return 3.

class Solution {
  public int getSum(int a, int b) {
    int sum = 0;
    boolean carry = false;
    for (int i=0; i<32; i++) {
      int mask = 1 << i;
      int bit = (a & mask) ^ (b & mask) ^ (carry ? mask : 0);
      carry = carry
        ? ((a & mask) | (b & mask)) > 0
        : ((a & mask) & (b & mask)) > 0;
      sum |= bit;
    }
    return sum;
  }
}

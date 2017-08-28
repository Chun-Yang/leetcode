// Given an integer, write a function to determine if it is a power of three.

// Follow up:
// Could you do it without using any loop / recursion?


class Solution {
  public static final int maxPowerOfThree = (int)Math.pow(
      3,
      (int)(Math.log(Integer.MAX_VALUE) / Math.log(3))
      );
  public boolean isPowerOfThree(int n) {
    return n>0 && Solution.maxPowerOfThree%n==0;
  }
}

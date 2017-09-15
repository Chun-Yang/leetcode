// Given a positive integer num, write a function which returns True if num is a
// perfect square else False.

// Note: Do not use any built-in library function such as sqrt.

// Example 1:

// Input: 16
// Returns: True
// Example 2:

// Input: 14
// Returns: False

// Solution: binary search
class Solution {
  public boolean isPerfectSquare(int num) {
    if (num <= 0) return false;

    int lo = 1;
    int hi = num;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (((long)mid * (long)mid) < num) lo = mid + 1;
      else hi = mid;
    }
    return num == lo * lo;
  }
}

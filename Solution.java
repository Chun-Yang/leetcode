// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.HashSet;
// import java.util.HashMap;

public class Solution {
  public int mySqrt(int x) {
    if (x == 0) return 0;

    int left = 1;
    int right = x;
    int mid;

    while (true) {
      mid = left + (right - left) / 2;
      if (mid > x / mid) {
        right = mid - 1;
      } else if (mid + 1 <= x / (mid + 1)) {
        left = mid + 1;
      } else {
        return mid;
      }
    }

    // while (left < right) {
    //   mid = left + (right - left) / 2;
    //   if (mid > x / mid) {
    //     right = mid;
    //   } else if (mid < x / mid) {
    //     left = mid + 1;
    //   } else {
    //     return mid;
    //   }
    // }

    // if (x / left < left) {
    //   return left - 1;
    // }
    // return left;
  }
  // public static void main (String[] args) {
  //   Solution s = new Solution();
  //   assert s.mySqrt(0) == 0;
  //   assert s.mySqrt(1) == 1;
  //   assert s.mySqrt(2) == 1;
  //   assert s.mySqrt(3) == 1;
  //   assert s.mySqrt(4) == 2;
  //   assert s.mySqrt(9) == 3;
  //   assert s.mySqrt(2147395599) == 46339;
  // }
}

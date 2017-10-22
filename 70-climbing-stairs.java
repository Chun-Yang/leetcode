// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Note: Given n will be a positive integer.

// solution2: dp
class Solution {
  public int climbStairs(int n) {
    if (n <= 1) return 1;
    int first = 1;
    int second = 1;
    int third = 0;

    for (int i=1; i<n; i++) {
      third = first + second;
      first = second;
      second = third;
    }

    return third;
  }
}

// solution1: dp
// class Solution {
//   public int climbStairs(int n) {
//     int x = 1;
//     int y = 1;
//     int z;
//     for (int i=1; i<n; i++) {
//       z = x + y;
//       x = y;
//       y = z;
//     }
//     return y;
//   }
//   // public static void main (String[] args) {
//   //   Solution s = new Solution();
//   //   assert s.climbStairs(1) == 1;
//   //   assert s.climbStairs(3) == 3;
//   //   assert s.climbStairs(4) == 5;
//   // }
// }

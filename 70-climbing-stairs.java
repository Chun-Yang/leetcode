public class Solution {
  public int climbStairs(int n) {
    int x = 1;
    int y = 1;
    int z;
    for (int i=1; i<n; i++) {
      z = x + y;
      x = y;
      y = z;
    }
    return y;
  }
  // public static void main (String[] args) {
  //   Solution s = new Solution();
  //   assert s.climbStairs(1) == 1;
  //   assert s.climbStairs(3) == 3;
  //   assert s.climbStairs(4) == 5;
  // }
}

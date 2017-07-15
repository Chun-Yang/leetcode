public class Solution {
  public int nthUglyNumber(int n) {
    int[] uglyNums = new int[n];
    Arrays.fill(uglyNums, Integer.MAX_VALUE);
    uglyNums[0] = 1;
    int[] primes = new int[]{2, 3, 5};
    int[] indexes = new int[]{0, 0, 0};
    for (int i=1; i<n; i++) {
      for (int j=0; j<3; j++) {
        uglyNums[i] = Math.min(uglyNums[i], uglyNums[indexes[j]] * primes[j]);
      }
      for (int j=0; j<3; j++) {
        if (uglyNums[i] == uglyNums[indexes[j]] * primes[j]) indexes[j]++;
      }
    }
    return uglyNums[n-1];
  }
}

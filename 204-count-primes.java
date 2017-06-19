public class Solution {
  public int countPrimes(int n) {
    int count = 0;
    boolean[] primes = new boolean[n];
    Arrays.fill(primes, true);

    for (int i=2; i<n; i++) {
      if (primes[i]) {
        count++;
        for (int j=2; j*i<n; j++) {
          primes[j*i] = false;
        }
      }
    }

    return count;
  }
}

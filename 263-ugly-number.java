public class Solution {
  public boolean isUgly(int num) {
    if (num <= 0) return false;
    int[] primes = new int[]{2, 3, 5};
    for (int p : primes) while(num % p == 0) num /= p;
    return num == 1;
  }
}

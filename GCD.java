import java.util.*;

public class GCD {
  public static void main (String[] args) {
    assert GCD.gcd(2, 1) == 1;
    assert GCD.gcd(2, 3) == 1;
    assert GCD.gcd(2, 4) == 2;
    assert GCD.gcd(4, 2) == 2;
    assert GCD.gcd(12, 8) == 4;
  }
  static int gcd(int a, int b) {
    if (a < b) return gcd(b, a);
    if (b == 0) return a;
    return gcd(b, a % b);
  }
}

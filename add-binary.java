// import java.util.Arrays;

public class Solution {
  public String addBinary(String a, String b) {
    int i = a.length();
    int j = b.length();
    int carry = 0;
    int sum = 0;
    StringBuilder sb = new StringBuilder();

    for (int k = 0; k < Math.max(i, j); k++) {
      sum = carry;
      if (k < i) sum += a.charAt(i - k - 1) - '0';
      if (k < j) sum += b.charAt(j - k - 1) - '0';
      carry = sum / 2;
      sb.append(sum % 2);
    }
    if (carry == 1) sb.append(1);
    return sb.reverse().toString();
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.addBinary("0", "0").equals("0");
    assert s.addBinary("10", "0").equals("10");
    assert s.addBinary("10", "1").equals("11");
    assert s.addBinary("11", "1").equals("100");
  }
}

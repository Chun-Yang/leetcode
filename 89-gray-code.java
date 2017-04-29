import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
  // public List<Integer> grayCode(int n) {
  //   Integer[] codes = new Integer[1 << n];
  //   codes[0] = 0;
  //   int exponent = 0;
  //   for (int i=1; i<(1 << n); i++) {
  //     if ((i & (1 << exponent)) != 0) {
  //       exponent++;
  //     }
  //     codes[i] = codes[(1 << exponent) - i - 1] + (1 << (exponent - 1));
  //   }

  //   return Arrays.asList(codes);
  // }
  public List<Integer> grayCode(int n) {
    List<Integer> codes = new ArrayList<Integer>();
    codes.add(0);

    for (int i=0; i<n; i++) {
      // double the array by reversing it
      for (int j=codes.size() - 1; j>=0; j--) {
        codes.add(codes.get(j) | 1 << i);
      }
    }

    return codes;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.grayCode(2).equals(Arrays.asList( 0, 1, 3, 2 ));
  }
}

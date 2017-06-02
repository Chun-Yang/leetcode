public class Solution {
  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      n--;
      sb.append((char)('A' + n % 26));
      n /= 26;
    }
    return sb.reverse().toString();
  }
  // public String convertToTitle(int n) {
  //   StringBuilder sb = new StringBuilder();
  //   while (n > 0) {
  //     int index = n % 26;
  //     if (index == 0) {
  //       sb.append('Z');
  //       n = n / 26 - 1;
  //     } else {
  //       sb.append((char)('A' + index - 1));
  //       n = n / 26;
  //     }
  //   }
  //   return sb.reverse().toString();
  // }
}

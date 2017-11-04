// Given a positive integer,
// return its corresponding column title as appear in an Excel sheet.
//
// For example:
//
// 1 -> A
// 2 -> B
// 3 -> C
// ...
// 26 -> Z
// 27 -> AA
// 28 -> AB


// https://leetcode.com/problems/excel-sheet-column-title

// solution1: minus 1 before % 26
// reason:
// A      1     0
// B      2     1
// AA     11    01
// AB     12    02
// BA     21    11
// BB     22    12
// AAA    111   000
// AAB    112   001

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

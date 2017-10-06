// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
// P   A   H   N
// A P L S I I G
// Y   I   R
//
//
// And then read line by line: "PAHNAPLSIIGYIR"
//
//
// Write the code that will take a string and make this conversion given a number of rows:
//
// string convert(string text, int nRows);
//
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


// https://leetcode.com/problems/zigzag-conversion

import java.util.*;

class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) return s;

    char [] chars = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    int period = numRows + numRows - 2;
    for (int phase=0; phase<numRows; phase++) {
      int step = 0;
      int firstIndex;
      int secondIndex;
      while (true) {
        firstIndex = step * period + phase;
        secondIndex = step * period + (period - phase);

        if (firstIndex >= chars.length) break;

        sb.append(chars[firstIndex]);
        if (phase > 0 && phase < numRows - 1 && secondIndex < chars.length) sb.append(chars[secondIndex]);

        step++;
      }
    }
    return sb.toString();
  }
}

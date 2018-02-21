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

#include <string>
#include <iostream>
#include <assert.h>
using namespace std;

/* NOTE: use good transform coordinates, two cycles,
 * draw the pattern using number */
class Solution {
public:
    string convert(string s, int numRows) {
      if (numRows == 1)
      {
        return s;
      }

      string r(s.size(), ' ');
      int i = 0;
      int period = numRows * 2 - 2;
      for (int phase = 0; phase < numRows; ++phase)
      {
        int cycle = 0;
        while(true)
        {
          int first = cycle * period + phase;
          if (first < s.size())
          {
            r[i++] = s[first];
          }
          else
          {
            break;
          }

          int second = cycle * period + period - phase;
          if (phase > 0 && phase < numRows - 1 && second < s.size())
          {
            r[i++] = s[second];
          }

          cycle++;
        }
      }
      return r;
    }
};

/* int main(int argc, char *argv[]) */
/* { */
/*   Solution s; */
/*   assert(s.convert("babc", 1) == "babc"); */
/*   assert(s.convert("babc", 2) == "bbac"); */
/*   /1* b b */
/*    * a c */
/*    * *1/ */
/*   return 0; */
/* } */

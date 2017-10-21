// Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
// return the length of last word in the string.
//
// If the last word does not exist, return 0.
//
// Note: A word is defined as a character sequence consists of non-space characters only.
//
//
// For example,
// Given s = "Hello World",
// return 5.


// https://leetcode.com/problems/length-of-last-word

// Solution1: pointer (start of last word)

class Solution {
  public int lengthOfLastWord(String s) {
    // end is exclusive
    int end = s.length();
    while (end > 0 && s.charAt(end-1) == ' ') end--; // skip all spaces
    // start is inclusive
    int start = end;
    while (start > 0 && s.charAt(start-1) != ' ') start--;
    return end - start;
  }
}

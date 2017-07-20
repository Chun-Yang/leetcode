// An image is represented by a binary matrix with 0 as a white pixel and
// 1 as a black pixel. The black pixels are connected, i.e., there is only
// one black region. Pixels are connected horizontally and vertically.
// Given the location (x, y) of one of the black pixels, return the area
// of the smallest (axis-aligned) rectangle that encloses all black
// pixels.

// For example, given the following image:

// [
//   "0010",
//   "0110",
//   "0100"
// ]
// and x = 0, y = 2,



// Return 6.

// public class Solution {
//   int minArea(char[][] image, int x, int y) {
//   }
// }
// Solution #1:
// O(m * n)
// for each row, find the left and right bound of column
// find the starting and ending row
// Solution #2:
// dfs O(black)
// Solution #3:
// https://discuss.leetcode.com/topic/29006/c-java-python-binary-search-solution-with-explanation

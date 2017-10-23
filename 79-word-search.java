// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell,
// where "adjacent" cells are those horizontally or vertically neighboring.
// The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

// https://leetcode.com/problems/word-search/description/

// solution1: dfs + backtracking
// l = word.length
// m = board height
// n = board width
// for each starting point, we move l steps, need to check collision
// time: O(3 ^ l * m * n)

class Solution {
  public boolean exist(char[][] board, String word) {
  }
}

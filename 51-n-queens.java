// The n-queens puzzle is the problem of placing n queens on an n×n chessboard
// such that no two queens attack each other.
//
//
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens'
// placement, where 'Q' and '.' both indicate a queen and an empty space
// respectively.
//
// For example,
// There exist two distinct solutions to the 4-queens puzzle:
//
// [
// [".Q..",  // Solution 1
// "...Q",
// "Q...",
// "..Q."],
//
// ["..Q.",  // Solution 2
// "Q...",
// "...Q",
// ".Q.."]
// ]


// https://leetcode.com/problems/n-queens

// Solution1: backtracking
// STEP1: save an array of number to indicate position
// for each position, we check if it is valid
// - same column
// - upLeft diagonal
// - upRight diagonal
// end condition: i == n
// STEP2: convert position into a string

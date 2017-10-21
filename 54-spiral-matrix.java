// Given a matrix of m x n elements (m rows, n columns),
// return all elements of the matrix in spiral order.
//
//
//
// For example,
// Given the following matrix:
//
//
// [
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
// ]
//
//
// You should return [1,2,3,6,9,8,7,4,5].


// https://leetcode.com/problems/spiral-matrix

// Solution1:
// 1,2
// 3,6
// 9,8
// 7,4
// edge case: single line (not a circle)
// https://discuss.leetcode.com/topic/3713/super-simple-and-easy-to-understand-solution/
// simple implimentation: keep track of cStart, cEnd, rStart, rEnd
// deal with the edge case using cStart < cEnd && rStart < rEnd
// deal with end case with cStart <= cEnd && rStart <= rEnd

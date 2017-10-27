// Given a string S and a string T, count the number of distinct subsequences
// of S which equals T.
//
//
//
// A subsequence of a string is a new string which is formed from the original
// string by deleting some (can be none) of the characters without disturbing
// the relative positions of the remaining characters. (ie, "ACE" is a
// subsequence of "ABCDE" while "AEC" is not).
//
//
//
// Here is an example:
// S = "rabbbit", T = "rabbit"
//
//
// Return 3.


// https://leetcode.com/problems/distinct-subsequences

// solution1: dp
// d1: length of S
// d2: length of T
// m[i][j] count of subsequences
// use all of T
// use part of S
// m[0][0] = 1
// m[i][j] = sum of m[x][j-1] where we match last char of T for each x

// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
// for example: "ACGAATTCCG". When studying DNA,
// it is sometimes useful to identify repeated sequences within the DNA.
//
// Write a function to find all the 10-letter-long sequences (substrings)
// that occur more than once in a DNA molecule.
//
//
// For example,
//
// Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
// Return:
// ["AAAAACCCCC", "CCCCCAAAAA"].


// https://leetcode.com/problems/repeated-dna-sequences

// Solution1: sliding window and two sets
// one set to save strings that appear once
// another set to save strings that appear twice
// O(n)
// optimization: bit manipulation, char to integer, 0,1,2,3, times 4

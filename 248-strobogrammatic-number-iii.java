// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

// For example,
// Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

// Note:
// Because the range might be a large number, the low and high numbers are represented as string.

// solution:
// http://www.cnblogs.com/grandyang/p/5203228.html

// - use compareTo to compare string as number
// - grow gradually (dfs)
// - base on top of fixed length, we check sTest whose length <= max >= min

// Given an unsorted array of integers, find the length of the longest
// consecutive elements sequence.
//
//
// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//
// Your algorithm should run in O(n) complexity.


// https://leetcode.com/problems/longest-consecutive-sequence

// attampt1: bucket sort? (max - min) / n as the width? Nop

// solution1: HashTable? two ends: starts, ends
// - extend ?
// - merge ?
// - loop over all starts
// https://discuss.leetcode.com/topic/6148/my-really-simple-java-o-n-solution-accepted

// solution2: walk each streak (use one set, find the first start and keeps trying)
// https://discuss.leetcode.com/topic/15383/simple-o-n-with-explanation-just-walk-each-streak/7

// solution3: try to find the left and right boundary for the current value
// update the three points for the length

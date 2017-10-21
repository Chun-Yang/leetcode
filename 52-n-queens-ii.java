// Follow up for N-Queens problem.
//
// Now, instead outputting board configurations,
// return the total number of distinct solutions.


// https://leetcode.com/problems/n-queens-ii

// Solution1: O(n ^ n * n)
// same as N-queens-i return number/count instead of configuration

// Solution2: O(n ^ n)
// https://discuss.leetcode.com/topic/5962/accepted-java-solution
// (set, clear)
// https://discuss.leetcode.com/topic/29626/easiest-java-solution-1ms-98-22
// (boolean array (more efficient))
// https://discuss.leetcode.com/topic/38923/share-my-java-code-beats-97-83-run-times
// (bit manipulation (most efficient) but can not deal with n > 32)
// we can map diagonal to the first row
// useing this:
// diag     = col - row
// antiDiag = col + row

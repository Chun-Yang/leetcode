// Reverse bits of a given 32 bits unsigned integer.
//
// For example, given input 43261596
// (represented in binary as 00000010100101000001111010011100),
// return 964176192
// (represented in binary as 00111001011110000010100101000000).
//
//
// Follow up:
// If this function is called many times, how would you optimize it?
//
//
// Related problem: Reverse Integer
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


// https://leetcode.com/problems/reverse-bits

// solution1: stack to save bits
// solution2: two reverses with cache bit mask, using two bit masks, one for read and one for write
// solution3: O(log(n))
// https://discuss.leetcode.com/topic/9811/o-1-bit-operation-c-solution-8ms

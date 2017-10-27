// Suppose you have a random list of people standing in a queue. Each person is
// described by a pair of integers (h, k), where h is the height of the person
// and k is the number of people in front of this person who have a height
// greater than or equal to h. Write an algorithm to reconstruct the queue.
//
//
// Note:
// The number of people is less than 1,100.
//
//
// Example
// Input:
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
// Output:
// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]


// https://leetcode.com/problems/queue-reconstruction-by-height

// solution1: insertion sort
// 1. sort by k ascending then h ascending

// 1. bucket sort?
// not since the original list is not sorted
// 2. topological sort?
// find
// 3. dfs? n!
// 3.1 sort by k
// 3.2 for each k, try to see if it can be at first
// 4. preprocessing, sort by h?
// [4,4] [5,0] [5,2] [6,1] [7,0] [7,1]
//
// [5,0]
// the first one has to have k == 0 and we should pick the smallest
// [5,0], [7,0]
// we assign k == 1, smaller h first
// since if larger h is first, the later's k is 1 larger than the previous one
// and this is a contradiction
// [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]

// solution1: insertion sort
// https://discuss.leetcode.com/topic/60394/easy-concept-with-python-c-java-solution
// thought: it may be easier to do proprocessing some times
// do not hang up on one possibility, instead try out different ideas

// Given an array of meeting time intervals consisting of start and end times
// [[s1,e1],[s2,e2],...] (si < ei),
// determine if a person could attend all meetings.
// For example, Given [[0, 30],[5, 10],[15, 20]], return false.

// solution1: sort by start time
// time: O(n * log(n)) extra space: O(1)

// solution2: balanced binary search tree
// time: O(n * log(n)) extra space: O(n)
// this is better since we may have early termination
// and we do not need to sort the whole array

// solution3: early termination with sorting, like solution2
// https://discuss.leetcode.com/topic/20959/ac-clean-java-solution/2
// time: O(n * log(n)) extra space: O(1)

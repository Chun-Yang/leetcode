// Given an array of meeting time intervals consisting of start and end times
// [[s1,e1],[s2,e2],...] (si < ei),
// determine if a person could attend all meetings.
// For example, Given [[0, 30],[5, 10],[15, 20]], return false.

// solution1: sort by start time
// time: O(n * log(n)) space: O(1)

// solution2: balanced binary search tree
// time: O(n * log(n)) space: O(n)
// this is better since we may have early termination
// and we do not need to sort the whole array
// TODO: check if anyone is doing this?

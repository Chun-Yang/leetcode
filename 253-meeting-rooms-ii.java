// Given an array of meeting time intervals consisting of start and end times
// [[s1,e1],[s2,e2],...]
// find the minimum number of conference rooms required.

// 1. sort by start
// 2. use a priorityqueue to save ends,
// find the min end, see if the start is larger than that, if is update end
// otherwise add a new one in queue
// return the pq size
// O(n * log(n))

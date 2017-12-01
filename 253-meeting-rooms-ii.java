// Given an array of meeting time intervals consisting of start and end times
// [[s1,e1],[s2,e2],...]
// find the minimum number of conference rooms required.

// solution1: greedy
// 1. sort by start
// 2. use a priorityqueue to save ends
// find the min end, see if the start is larger than that,
// yes: update end with current end
// no:  add a new one in queue
// return the pq size
// O(n * log(n))
// proof:
// simple case: one this is correct
// recursive case:
// if we do not use the end_min, instead we use end_x > end_min
// 1. end_x > start && end_min < start we add an extra room
// current: end_min end_i
// use min: end_x   end_i
// 2. end_x < start

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
// simple case: one meeting (apprant)
// recursive case:
// if we do not use the end_min, instead we use end_not_min > end_min
// 1. end_not_min > start_i && end_min < start_i we add an extra room
// current: end_not_min end_i end_min
// use min: end_not_min end_i
// the "use min" one is better
// we can manually create a room starts at 0 and beat the current one
// 2. end_not_min < start_i
// current: end_i end_min
// use-min: end_i end_not_min
// since start_i is larger than end_not_min,
// end_min and end_not_min are equivalent

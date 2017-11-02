// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.


// https://leetcode.com/problems/max-points-on-a-line

// 0. we can preprocess the points to get the counts
// 1. find all lines k * x + b or x = ...
// 2. assign points to each line and track the number of lines using HashMap
//    k,b or x

// for each point we can find the maximum count

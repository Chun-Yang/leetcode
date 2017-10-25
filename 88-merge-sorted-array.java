// Given two sorted integer arrays nums1 and nums2,
// merge nums2 into nums1 as one sorted array.
//
//
// Note:
// You may assume that nums1 has enough space
// (size that is greater or equal to m + n)
// to hold additional elements from nums2. The number of elements
// initialized in nums1 and nums2 are m and n respectively.


// https://leetcode.com/problems/merge-sorted-array

// solution1: pointers
// - a iterator start from the end of nums1 (m + n - 1) till 0
// - a pointer at the end of nums1
// - a pointer at the end of nums2

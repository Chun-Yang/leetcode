// Given a string, we can "shift" each of its letter to its successive letter,
// for example: "abc" -> "bcd". We can keep "shifting" which forms the
// sequence: "abc" -> "bcd" -> ... -> "xyz".

// Given a list of strings which contains only lowercase alphabets, group all
// strings that belong to the same shifting sequence, return:

// [
//   ["abc","bcd","xyz"],
//   ["az","ba"],
//   ["acef"],
//   ["a","z"]
// ]

// solution1:
// 1. group by size
// 2. create a string that contains distance from the first letter( number to string ), saparate by ,
// use HashMap to save groups
// NOTE: 1 and 2 can be done at the same time by using a key

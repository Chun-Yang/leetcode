// Design an algorithm to encode a list of strings to a string.
// The encoded string is then sent over the network and
// is decoded back to the original list of strings.

// solution1: JSON encode and decode
// this is not the most space efficient

// solution2: custom encode and decode
// https://discuss.leetcode.com/topic/31084/java-solution-pretty-straight-forward
// - encode:
//   - , -> \, and \ -> \\
//   - join with , (or just append to all strings)
// - decode:
//   - \? -> ?
//   - , to split

// solution3: use string length
// https://discuss.leetcode.com/topic/22848/ac-java-solution
// abc,defg -> 3/abc4/defg

// solution4: use " # " to split
// https://discuss.leetcode.com/topic/24013/java-with-escaping

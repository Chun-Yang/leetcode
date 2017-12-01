// This is a follow up of Shortest Word Distance. The only difference is now
// you are given the list of words and your method will be called repeatedly
// many times with different parameters. How would you optimize it?

// Design a class which receives a list of words in the constructor, and
// implements a method that takes two words word1 and word2 and return the
// shortest distance between these two words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “coding”, word2 = “practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.

// solution1:
// record indexes for each word, use two pointers to hop through indexes
// of each word
// optimization1(lazy): use cache to save the result for the pair
// initialization: time: O(n) space: O(n)
// query: time: O(n) O(1) amortized space: O(n ^ 2)
// optimization2(eager): precalculate cache
// initialization: time: O(n ^ 2) space: O(n ^ 2)
// query: time: O(1) space: O(n ^ 2)

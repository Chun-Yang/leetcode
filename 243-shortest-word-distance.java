// Given a list of words and two words word1 and word2, return the shortest
// distance between these two words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “coding”, word2 = “practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.

// solution1: two pointers
// p1 -> word1
// p2 -> word2
// p1 = -1
// p2 = -1
// when the word matches word1 or word2, we move the pointer and record
// the distance if the other is not -1

// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “coding”, word2 = “practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.


// Solution:
// int wordIndex = -1;
// int min = Integer.MAX_INT
// loop words
// - nextWord == firstWord || nextWord == secondWord
//   - wordIndex == -1: wordIndex = nextIndex
//   - nextWord == word: wordindex = nextIndex
//   - nextWord != word: min = nextIndex = index
// - other

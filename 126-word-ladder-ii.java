// Given two words (beginWord and endWord), and a dictionary's word list, find
// all shortest transformation sequence(s) from beginWord to endWord, such
// that:
//
//
// Only one letter can be changed at a time
// Each transformed word must exist in the word list. Note that beginWord is
// not a transformed word.
//
//
//
// For example,
//
//
// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
//
//
// Return
//
// [
// ["hit","hot","dot","dog","cog"],
// ["hit","hot","lot","log","cog"]
// ]
//
//
//
//
// Note:
//
// Return an empty list if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
//
//
//
//


// https://leetcode.com/problems/word-ladder-ii

// solution1 bfs
// - build adjancy HashMap<String, HashSet<String>>
//   - for each position, we test out 26 different charactors
//   wl is the length of the word
// - track visited words
// - find min length
// - get all lists using the length as a limit

// solution2 bfs + dfs
// - bfs to build adj and the distance
// - dfs to find all occurances

// solution3 two end bfs
// https://discuss.leetcode.com/topic/17975/super-fast-java-solution-two-end-bfs

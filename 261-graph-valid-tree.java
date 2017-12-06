// Given n nodes labeled from 0 to n - 1 and a list of undirected edges
// (each edge is a pair of nodes), check if these edges form a valid tree.

// solution1: naive, too complicated
// 1. there should be n-1 edges
// 2. each node should connect to at least one edge
// 3. there is no loop
// using HashMap {
// a: HashSet[b, c],
// b: HashSet[a],
// c: HashSet[a],
// }
// when we encounter another value in the HashSet, it should break
// dfs from one node, new nodes should not be visited

// solution2:
// union find
// https://discuss.leetcode.com/topic/21712/ac-java-union-find-solution

// solution3:
// dfs
// https://discuss.leetcode.com/topic/21714/ac-java-graph-dfs-solution-with-adjacency-list
// NOTE: for a valid tree, it does not matter where we start,
// we will still have a top to bottom tree structure
// so the only posibility that we encouter a visited node is the current
// node's parent

class Solution {
  public boolean validTree(int n, int[][] edges) {
  }
}

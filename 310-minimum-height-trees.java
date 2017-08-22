// For a undirected graph with tree characteristics, we can choose any node as
// the root. The result graph is then a rooted tree. Among all possible rooted
// trees, those with minimum height are called minimum height trees (MHTs).
// Given such a graph, write a function to find all the MHTs and return a list
// of their root labels.

// Format The graph contains n nodes which are labeled from 0 to n - 1. You
// will be given the number n and a list of undirected edges (each edge is a
// pair of labels).

// You can assume that no duplicate edges will appear in edges. Since all edges
// are undirected, [0, 1] is the same as [1, 0] and thus will not appear
// together in edges.

// Example 1:

// Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

//        0
//        |
//        1
//       / \
//      2   3

// Example 2:

// Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

//   0  1  2
//    \ | /
//      3
//      |
//      4
//      |
//      5

// Note:

// (1) According to the definition of tree on Wikipedia: “a tree is an
// undirected graph in which any two vertices are connected by exactly one
// path. In other words, any connected graph without simple cycles is a tree.”

// (2) The height of a rooted tree is the number of edges on the longest
// downward path between the root and a leaf.

import java.util.*;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assert s.findMinHeightTrees(4, new int[][]{ new int[]{1, 0}, new int[]{1, 2}, new int[]{1, 3} })
      .equals(Arrays.asList(1));
  }

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i=0; i<n; i++) map.put(i, new HashSet<Integer>());

    for (int[] edge : edges) {
      int x = edge[0];
      int y = edge[1];
      map.get(x).add(y);
      map.get(y).add(x);
    }

    List<Integer> leaves = new ArrayList<>();
    for (int i=0; i<n; i++) {
      if (map.get(i).size() == 1) leaves.add(i);
    }

    while (map.size() > leaves.size()) {
      List<Integer> nextLeaves = new ArrayList<>();

      for (int leaf : leaves) {
        int branch = map.get(leaf).iterator().next();
        map.get(branch).remove(leaf);
        if (map.get(branch).size() == 1) nextLeaves.add(branch);
      }

      leaves = nextLeaves;
    }

    return leaves;
  }
}

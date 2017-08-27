// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge
//     is a pair of nodes), write a function to find the number of connected
// components in an undirected graph.

// Example 1:
// 0 3
// | |
// 1 --- 2 4
// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.


import java.util.*;

class Solution {
  public static void main (String[] args) {
    Solution s = new Solution();
  }
  public int countComponents(int n, int[][] edges) {
    int[] parents = new int[n];
    for (int i=0; i<n; i++) parents[i] = i;
    for (int[] edge : edges) {
      int leftParent = find(parents, edge[0]);
      int rightParent = find(parents, edge[1]);
      parents[rightParent] = leftParent;
    }
    int count = 0;
    for (int i=0; i<n; i++) {
      if (parents[i] == i) count++;
    }
    return count;
  }
  private int find(int[] parents, int i) {
    if (parents[i] == i) return i;
    int parent = find(parents, parents[i]);
    parents[i] = parent;
    return parent;
  }
}

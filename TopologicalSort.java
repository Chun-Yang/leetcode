import java.util.*;

public class TopologicalSort {
  public static void main (String[] args) {
    assert Arrays.equals(
        TopologicalSort.sort(
          new int[][]{
            new int[] { 0, 3 },
                new int[] { 0, 4 },
                new int[] { 1, 2 },
                new int[] { 1, 5 },
                new int[] { 2, 3 },
                new int[] { 2, 5 },
                new int[] { 3, 4 },
                new int[] { 3, 5 },
                new int[] { 4, 6 },
                new int[] { 5, 6 },
          },
          7
          ),
        new int[] { 1, 2, 0, 3, 5, 4, 6 }
        );
  }
  private TopologicalSort() {}

  public static int[] sort(int[][] edges, int n) {
    List<Integer> vertices = new ArrayList<Integer>();
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    for (int[] edge : edges) {
      adj.putIfAbsent(edge[0], new ArrayList<Integer>());
      adj.get(edge[0]).add(edge[1]);
    }

    boolean[] visited = new boolean[n];
    for (int i=0; i<n; i++) {
      dfs(vertices, adj, visited, i);
    }

    Collections.reverse(vertices);
    int i=0;
    int[] sorted = new int[n];
    for (int v : vertices) sorted[i++] = v;
    return sorted;
  }
  private static void dfs(List<Integer> vertices, HashMap<Integer, ArrayList<Integer>> adj, boolean[] visited, int i) {
    if (visited[i]) return;

    if (adj.containsKey(i)) {
      for (int j : adj.get(i)) {
        dfs(vertices, adj, visited, j);
      }
    }

    visited[i] = true;
    vertices.add(i);
  }
}

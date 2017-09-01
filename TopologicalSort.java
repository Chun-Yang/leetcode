import java.util.*;

public class TopologicalSort {
  public static void main (String[] args) {
    assert Arrays.equals(
        TopologicalSort.dfsSort(
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

    assert Arrays.equals(
        TopologicalSort.degreeSort(
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
        new int[] { 0, 1, 2, 3, 4, 5, 6 }
        );

    assert Arrays.equals(
        TopologicalSort.degreeSort(
          new int[][]{
          new int[] { 0, 3 },
          new int[] { 0, 4 },
          new int[] { 1, 2 },
          new int[] { 1, 5 },
          new int[] { 1, 6 },
          new int[] { 2, 0 },
          new int[] { 2, 3 },
          new int[] { 2, 5 },
          new int[] { 3, 4 },
          new int[] { 3, 5 },
          new int[] { 4, 6 },
          new int[] { 5, 6 },
          },
          7
          ),
        new int[] { 1, 2, 0, 3, 4, 5, 6 }
        );
  }
  private TopologicalSort() {}

  // kahn's algorithm
  public static int[] degreeSort(int[][] edges, int n) {
    ArrayList<Integer> vertices = new ArrayList<Integer>();
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    for (int[] edge : edges) {
      adj.putIfAbsent(edge[0], new ArrayList<Integer>());
      adj.get(edge[0]).add(edge[1]);
    }

    // calculate indegrees
    int[] indegrees = new int[n];
    for (int from : adj.keySet()) {
      for (int to : adj.get(from)) {
        indegrees[to]++;
      }
    }

    // get all vertices that indegrees are zero and put it into queue
    Queue<Integer> starts = new LinkedList<Integer>();
    for (int i=0; i<n; i++) {
      if (indegrees[i] == 0) starts.offer(i);
    }

    // update queue and populate vertices
    while (!starts.isEmpty()) {
      int start = starts.poll();
      vertices.add(start);
      if (adj.containsKey(start)) {
        for (int to : adj.get(start)) {
          if (--indegrees[to] == 0) starts.offer(to);
        }
      }
    }

    int i=0;
    int[] sorted = new int[n];
    for (int v : vertices) sorted[i++] = v;
    return sorted;
  }

  // dfsSort
  public static int[] dfsSort(int[][] edges, int n) {
    LinkedList<Integer> vertices = new LinkedList<Integer>();
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    for (int[] edge : edges) {
      adj.putIfAbsent(edge[0], new ArrayList<Integer>());
      adj.get(edge[0]).add(edge[1]);
    }

    boolean[] visited = new boolean[n];
    for (int i=0; i<n; i++) {
      dfs(vertices, adj, visited, i);
    }

    int i=0;
    int[] sorted = new int[n];
    for (int v : vertices) sorted[i++] = v;
    return sorted;
  }
  private static void dfs(LinkedList<Integer> vertices, HashMap<Integer, ArrayList<Integer>> adj, boolean[] visited, int i) {
    if (visited[i]) return;

    if (adj.containsKey(i)) {
      for (int j : adj.get(i)) {
        dfs(vertices, adj, visited, j);
      }
    }

    visited[i] = true;
    vertices.addFirst(i);
  }
}

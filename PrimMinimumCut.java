import java.util.*;

class Vertex {
  int dist;
  int index;
  public Vertex(int dist, int index) {
    this.dist = dist;
    this.index = index;
  }
}
public class PrimMinimumCut {
  public static void main (String[] args) {
    int[][] edges;
    edges = new int[][] {
      new int[]{1,  7, 6},
      new int[]{2,  8, 2},
      new int[]{2,  6, 5},
      new int[]{4,  0, 1},
      new int[]{4,  2, 5},
      new int[]{6,  8, 6},
      new int[]{7,  2, 3},
      new int[]{7,  7, 8},
      new int[]{8,  0, 7},
      new int[]{8,  1, 2},
      new int[]{9,  3, 4},
      new int[]{10, 5, 4},
      new int[]{11, 1, 7},
      new int[]{14, 3, 5},
    };
    assert PrimMinimumCut.minCut(edges, 9) == 37;
  }
  static int minCut(int[][] edges, int n) {
    if (n <= 0) return 0;

    // build adjancy map
    HashMap<Integer, ArrayList<Vertex>> adj = new HashMap<>();
    for (int[] edge : edges) {
      adj.putIfAbsent(edge[1], new ArrayList<Vertex>());
      adj.get(edge[1]).add(new Vertex(edge[0], edge[2]));
      adj.putIfAbsent(edge[2], new ArrayList<Vertex>());
      adj.get(edge[2]).add(new Vertex(edge[0], edge[1]));
    }
    // save visited set, stop when visited size is n
    boolean[] visited = new boolean[n];
    // a PQ to save all vertex with a distance
    PriorityQueue<Vertex> vertices = new PriorityQueue<>(n, new Comparator<Vertex>() {
      public int compare(Vertex v1, Vertex v2) {
        return v1.dist - v2.dist;
      }
    });
    vertices.offer(new Vertex(0, 0));
    int cut = 0;

    int visitedCount = 0;
    while (visitedCount < n) {
      Vertex v = vertices.poll();
      if (!visited[v.index]) {
        visited[v.index] = true;
        visitedCount++;
        cut += v.dist;
        if (adj.containsKey(v.index)) {
          for (Vertex vNext : adj.get(v.index)) {
            vertices.offer(vNext);
          }
        }
      }
    }

    return cut;
  }
}

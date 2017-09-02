import java.util.*;

public class KruskalMinimumCut {
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
    assert KruskalMinimumCut.minCut(edges, 9) == 37;
  }
  static int minCut(int[][] edges, int n) {
    int[] parents = new int[n];
    for (int i=0; i<n; i++) parents[i] = i;
    Arrays.sort(edges, Comparator.comparing((int[] edge) -> edge[0]));
    // sort edges
    // NO: add the edge to cut
    // YES: discard the edge
    int cut = 0;

    for (int[] edge : edges) {
      if (getOrigin(edge[1], parents) != getOrigin(edge[2], parents)) {
        // NOTE: we merge the two origins!
        parents[getOrigin(edge[1], parents)] = getOrigin(edge[2], parents);
        cut += edge[0];
      }
    }

    return cut;
  }
  static int getOrigin(int i, int[] parents) {
    if (parents[i] == i) return i;
    parents[i] = getOrigin(parents[i], parents);
    return parents[i];
  }
}

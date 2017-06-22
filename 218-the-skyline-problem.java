// |         |
// | |     | |
// | | | | | |
// l l l r r r
public class Solution {
  public List<int[]> getSkyline(int[][] buildings) {
    int[][] changes = new int[buildings.length * 2][4];
    for (int i=0; i<buildings.length; i++) {
      int[] building = buildings[i];
      int l = building[0];
      int r = building[1];
      int h = building[2];
      // i, v, h, l
      // 0 means left, 1 means right
      changes[2*i]     = new int[]{ i, l, h, 0 };
      changes[2*i + 1] = new int[]{ i, r, h, 1 };
    }

    Arrays.sort(changes, new Comparator<int[]>() {
      public int compare(int[] x, int[] y) {
        if (x[1] != y[1]) return x[1] - y[1];
        if (x[3] != y[3]) return x[3] - y[3];
        return y[3] == 0 ? y[2] - x[2] : x[2] - y[2];
      }
    });
    // for (int[] c : changes) {
    //   System.out.println(Arrays.toString(c));
    // }

    // i: h
    TreeMap<Integer, Integer> tree = new TreeMap<>();
    tree.put(0, 1);

    List<int[]> points = new ArrayList<>();
    int height = 0;
    for (int j=0; j<changes.length; j++) {
      int[] change = changes[j];
      int i = change[0];
      int v = change[1];
      int h = change[2];
      int l = change[3];

      if (l == 0) {
        // left
        int count = tree.get(h) == null ? 1 : tree.get(h) + 1;
        tree.put(h, count);
      } else {
        // right
        tree.put(h, tree.get(h) - 1);
        if (tree.get(h) == 0) {
          tree.remove(h);
        }
      }
      int curHeight = tree.lastKey();
      if (curHeight != height) {
        height = curHeight;
        points.add(new int[]{ v, height });
      }
    }
    return points;
  }
}

// A 2d grid map of m rows and n columns is initially filled with water. We may
// perform an addLand operation which turns the water at position (row, col) into
// a land. Given a list of positions to operate, count the number of islands after
// each addLand operation. An island is surrounded by water and is formed by
// connecting adjacent lands horizontally or vertically. You may assume all four
// edges of the grid are all surrounded by water.















import java.util.*;

class Solution {
  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.numIslands2(1, 1, new int[][]{}).equals(Arrays.asList());
    assert s.numIslands2(1, 1, new int[][]{ new int[]{0 , 0} }).equals(Arrays.asList(1));
    assert s.numIslands2(2, 2, new int[][]{ new int[]{0 , 0}, new int[]{1, 1} }).equals(Arrays.asList(1, 2));
    assert s.numIslands2(2, 2, new int[][]{ new int[]{0 , 1}, new int[]{1, 1} }).equals(Arrays.asList(1, 1));
    assert s.numIslands2(2, 2, new int[][]{ new int[]{0 , 0}, new int[]{1, 1}, new int[]{0 , 1}, new int[]{1, 0} }).equals(Arrays.asList(1, 2, 1, 1));
  }

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    // initialize parents
    // NOTE: https://www.programcreek.com/2015/01/leetcode-number-of-islands-ii-java/
    // we can flatten 2d array and use 1d
    int[][][] parents = new int[m][n][2];
    int[] water = new int[]{ -1, -1 };
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        parents[i][j] = water;
      }
    }

    int count = 0;
    List<Integer> counts = new ArrayList<>();

    for (int i=0; i<positions.length; i++) {
      count++;

      int x = positions[i][0];
      int y = positions[i][1];
      parents[x][y] = positions[i];

      List<int[]> neighbors = new ArrayList<>();
      if (x - 1 >= 0) neighbors.add(new int[]{x - 1, y});
      if (x + 1 < m ) neighbors.add(new int[]{x + 1, y});
      if (y - 1 >= 0) neighbors.add(new int[]{x, y - 1});
      if (y + 1 < n ) neighbors.add(new int[]{x, y + 1});

      for (int[] neighbor : neighbors) {
        if (Arrays.equals(parents[neighbor[0]][neighbor[1]], water)) break;

        int[] origin = findOrigin(neighbor, parents);
        if (!Arrays.equals(origin, positions[i])) {
          count--;
          parents[origin[0]][origin[1]] = positions[i];
        }
      }

      counts.add(count);
    }

    return counts;
  }

  private int[] findOrigin(int[] neighbor, int[][][] parents) {
    int[] p = parents[neighbor[0]][neighbor[1]];
    if (Arrays.equals(neighbor, p)) return neighbor;
    int[] o = findOrigin(p, parents);
    parents[neighbor[0]][neighbor[1]] = o;
    return o;
  }
}

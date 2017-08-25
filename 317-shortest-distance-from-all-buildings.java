// You want to build a house on an empty land which reaches all buildings in the
// shortest amount of distance. You can only move up, down, left and right. You
// are given a 2D grid of values 0, 1 or 2, where:

// Each 0 marks an empty land which you can pass by freely.
// Each 1 marks a building which you cannot pass through.
// Each 2 marks an obstacle which you cannot pass through.
// For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

// 1 - 0 - 2 - 0 - 1
// |   |   |   |   |
// 0 - 0 - 0 - 0 - 0
// |   |   |   |   |
// 0 - 0 - 1 - 0 - 0
// The point (1,2) is an ideal empty land to build a house, as the total travel
// distance of 3+3+1=7 is minimal. So return 7.

// Note:
// There will be at least one building. If it is not possible to build such house
// according to the above rules, return -1.

// NOTE: this is not tested
import java.util.*;

class Solution {
  public int shortestDistanceFromAllBuildings(int[][] map) {
    int shortest = Integer.MAX_VALUE;
    int m = map.length;
    int n = map[0].length;
    int buildingTotal = 0;
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (map[i][j] == 1) buildingTotal++;
      }
    }

    int[][] directions = new int[][]{
      new int[]{ -1, -1 },
      new int[]{ 1, -1 },
      new int[]{ -1, 1 },
      new int[]{ 1, 1 },
    };

    boolean[][] visited = new boolean[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        // BFS
        // 0: road
        // 1: building
        // 2: obstacle
        if (map[i][j] == 0) {
          for (int k=0; k<m; k++) Arrays.fill(visited[i], false);
          int distance = 0;
          int sum = 0;
          int buildings = 0;
          List<int[]> boundary = new ArrayList<>();
          boundary.add(new int[]{ i, j });
          visited[i][j] = true;

          while (!boundary.isEmpty()) {
            distance++;
            List<int[]> nextBoundary = new ArrayList<>();

            for (int[] p : boundary) {
              int x = p[0];
              int y = p[1];
              if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                if (map[x][y] == 0) {
                  for (int[] direction : directions) {
                    nextBoundary.add(new int[]{ x+direction[0], y+direction[1] });
                  }
                } else if (map[x][y] == 1) {
                  buildings++;
                  sum += distance;
                }
                visited[x][y] = true;
              }
            }

            boundary = nextBoundary;
          }

          if (buildings == buildingTotal) shortest = Math.min(shortest, sum);
        }
      }
    }

    return shortest == Integer.MAX_VALUE ? -1 : shortest;
  }
}

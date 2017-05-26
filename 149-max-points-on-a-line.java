/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
  public int maxPoints(Point[] points) {
    int max = 0;
    int length = points.length;
    for (int i=0; i<length; i++) {
      int curPoints = 0;
      int curMax = 0;
      int xi = points[i].x;
      int yi = points[i].y;
      HashMap<String, Integer> lines = new HashMap<>();
      for (int j=0; j<length; j++) {
        int dx = xi - points[j].x;
        int dy = yi - points[j].y;
        if (dx == 0 && dy == 0) {
          curPoints++;
          continue;
        }

        int g = gcd(dx, dy);
        dx /= g;
        dy /= g;
        String key = dx + " " + dy;

        int count = lines.getOrDefault(key, 0) + 1;
        lines.put(key, count);
        curMax = Math.max(curMax, count);
      }
      max = Math.max(max, curMax + curPoints);
    }

    return max;
  }

  private int gcd(int x, int y) {
    if (y == 0) return x;
    return gcd(y, x%y);
  }
}

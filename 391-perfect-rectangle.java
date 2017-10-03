// Given N axis-aligned rectangles where N > 0, determine if they all together
// form an exact cover of a rectangular region.

// Each rectangle is represented as a bottom-left point and a top-right point. For
// example, a unit square is represented as [1,1,2,2].
// (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).


// Example 1:

// rectangles = [
//   [1,1,3,3],
//   [3,1,4,2],
//   [3,2,4,4],
//   [1,3,2,4],
//   [2,3,3,4]
// ]

// Return true. All 5 rectangles together form an exact cover of a rectangular region.

// Example 2:

// rectangles = [
//   [1,1,2,3],
//   [1,3,2,4],
//   [3,1,4,2],
//   [3,2,4,4]
// ]

// Return false. Because there is a gap between the two rectangular regions.

// Example 3:

// rectangles = [
//   [1,1,3,3],
//   [3,1,4,2],
//   [1,3,2,4],
//   [3,2,4,4]
// ]

// Return false. Because there is a gap in the top center.

// Example 4:

// rectangles = [
//   [1,1,3,3],
//   [3,1,4,2],
//   [1,3,2,4],
//   [2,2,4,4]
// ]

// Return false. Because two of the rectangles overlap with each other.

import java.util.*;

class Solution {
  public boolean isRectangleCover(int[][] rectangles) {
    int n = rectangles.length;
    if (n == 0) return false;

    // left up right down
    int[] corners = new int[]{
      Integer.MAX_VALUE,
      Integer.MAX_VALUE,
      Integer.MIN_VALUE,
      Integer.MIN_VALUE
    };
    int totalArea = 0;
    HashSet<String> points = new HashSet<String>();
    for (int[] r : rectangles) {
      for (int i=0; i<4; i++) {
        corners[i] = i >= 2
          ? Math.max(corners[i], r[i])
          : Math.min(corners[i], r[i]);
      }
      totalArea += (r[2]-r[0]) * (r[3]-r[1]);

      String[] keys = new String[]{
        r[0] + " " + r[1],
        r[2] + " " + r[1],
        r[0] + " " + r[3],
        r[2] + " " + r[3]
      };
      for (String key : keys) {
        if (points.contains(key)) {
          points.remove(key);
        } else {
          points.add(key);
        }
      }
    }

    int totalAreaExpected = (corners[2]-corners[0]) * (corners[3]-corners[1]);
    if (totalAreaExpected != totalArea) return false;

    String[] keys = new String[]{
      corners[0] + " " + corners[1],
      corners[2] + " " + corners[1],
      corners[0] + " " + corners[3],
      corners[2] + " " + corners[3]
    };
    for (String key : keys) {
      if (points.contains(key)) {
        points.remove(key);
      } else {
        return false;
      }
    }
    return points.isEmpty();
  }
}

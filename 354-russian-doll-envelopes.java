// You have a number of envelopes with widths and heights given as a pair of
// integers (w, h). One envelope can fit into another if and only if both the
// width and height of one envelope is greater than the width and height of the
// other envelope.

// What is the maximum number of envelopes can you Russian doll? (put one inside other)

// Example:
// Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes
// you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

import java.util.*;

// Solution: greedy dp
// 300-longest-increasing-subsequence.java
class Solution {
  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, new Comparator<int[]>() {
      public int compare(int[] e1, int[] e2) {
        return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
      }
    });

    int[] mins = new int[envelopes.length];
    int maxCount = 0;

    for (int i=0; i<envelopes.length; i++) {
      int lo = 0;
      int hi = maxCount;
      int height = envelopes[i][1];
      while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (height > mins[mid]) lo = mid + 1;
        else hi = mid;
      }
      mins[lo] = height;
      if (lo == maxCount) maxCount++;
    }

    return maxCount;
  }
}

// Solution: naive dp
// class Solution {
//   public int maxEnvelopes(int[][] envelopes) {
//     Arrays.sort(envelopes, new Comparator<int[]>() {
//       public int compare(int[] e1, int[] e2) {
//         return e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0];
//       }
//     });

//     int[] maxCounts = new int[envelopes.length];
//     Arrays.fill(maxCounts, 1);
//     for (int i=0; i<envelopes.length; i++) {
//       for (int j=0; j<i; j++) {
//         if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
//           maxCounts[i] = Math.max(maxCounts[j] + 1, maxCounts[i]);
//         }
//       }
//     }

//     int maxCount = 0;
//     for (int i=0; i<envelopes.length; i++) maxCount = Math.max(maxCount, maxCounts[i]);
//     return maxCount;
//   }
// }

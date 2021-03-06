// Given two words word1 and word2, find the minimum number of steps
// required to convert word1 to word2. (each operation is counted as 1 step.)

// You have the following 3 operations permitted on a word:

// a) Insert a character
// b) Delete a character
// c) Replace a character

// solution1:
// dp, create a distance matrix, use length as the bases
// time: O(mn), space O(mn)
// NOTE: we can improve space to O(Math.min(m, n))
// NOTE: reason when word1.charAt(i-1) == word2.charAt(j-1),
// we only need distance[i-1][j-1]:
// for this case, we have
// ------x
// ---------x
// the cases to compare are:
// - remove both x
// ------
// ---------
// - remove first x, and add 1 to this case
// ------x
// ---------
// - remove second x, and add 1 to this case
// ------
// ---------x
// since we can construct case 2 and case 3 from case 1 with distance
// no more than those cases, its safe to just use the first case without
// comparation
import java.util.*;

class Solution {
  public int minDistance(String word1, String word2) {
    int l1 = word1.length();
    int l2 = word2.length();
    int[][] distance = new int[1 + l1][1 + l2];
    for (int i=0; i <= l1; i++) {
      distance[i][0] = i;
    }
    for (int j=0; j <= l2; j++) {
      distance[0][j] = j;
    }
    for (int i=1; i <= l1; i++) {
      for (int j=1; j <= l2; j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
          distance[i][j] = distance[i-1][j-1];
        } else {
          distance[i][j] = Math.min(
              Math.min(distance[i-1][j] + 1, distance[i][j-1] + 1),
              distance[i-1][j-1] + 1
              );
        }
      }
    }
    return distance[l1][l2];
  }

  public static void main (String[] args) {
    Solution s = new Solution();

    assert s.minDistance("", "") == 0;
    assert s.minDistance("a", "") == 1;
    assert s.minDistance("", "a") == 1;
    assert s.minDistance("ab", "cd") == 2;
    assert s.minDistance("ab", "ab") == 0;
  }
}

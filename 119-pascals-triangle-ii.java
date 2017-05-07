import java.util.*;

/**
 * 0: 1
 * 1: 1 1
 * 2: 1 2 1
 * 3: 1 3 3 1
 */
public class Solution {
  public List<Integer> getRow(int rowIndex) {
    int[] row = new int[rowIndex+1];

    row[0] = 1;
    for (int i=1; i<=rowIndex; i++) {
      for (int j=i; j>0; j--) {
        row[j] += row[j-1];
      }
    }

    List<Integer> l = new ArrayList<Integer>();
    for (int i=0; i<=rowIndex; i++) {
      l.add(row[i]);
    }
    return l;
  }
}

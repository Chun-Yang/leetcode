import java.util.*;

public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int height = triangle.size();
    int[] sums = new int[height];

    List<Integer> lastLevel = triangle.get(height-1);
    for (int i=0; i<height; i++) sums[i] = lastLevel.get(i);

    for (int i=height-2; i>=0; i--) {
      List<Integer> level = triangle.get(i);
      for (int j=0; j<=i; j++) {
        sums[j] = Math.min(sums[j], sums[j+1]) + level.get(j);
      }
    }
    return sums[0];
  }
  // public int minimumTotal(List<List<Integer>> triangle) {
  //   int height = triangle.size();
  //   int[] sums = new int[height];
  //   sums[0] = triangle.get(0).get(0);

  //   for (int i=1; i<height; i++) {
  //     List<Integer> level = triangle.get(i);
  //     sums[i] = sums[i-1] + level.get(i);
  //     for (int j=i-1; j>0; j--) {
  //       sums[j] = Math.min(
  //           sums[j] + level.get(j),
  //           sums[j-1] + level.get(j)
  //           );
  //     }
  //     sums[0] = sums[0] + level.get(0);
  //   }

  //   int min = Integer.MAX_VALUE;
  //   for (int i=0; i<height; i++) min = Math.min(min, sums[i]);
  //   return min;
  // }
}

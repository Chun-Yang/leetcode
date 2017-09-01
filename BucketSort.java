import java.util.*;

public class BucketSort {
  public static void main (String[] args) {
    assert Arrays.equals(new int[] {}, BucketSort.sort(new int[] {}));
    assert Arrays.equals(new int[] { 1 }, BucketSort.sort(new int[] { 1 }));
    assert Arrays.equals(new int[] { 1, 2 }, BucketSort.sort(new int[] { 2, 1 }));
    assert Arrays.equals(new int[] { 1, 2, 3, 4 }, BucketSort.sort(new int[] { 3, 4, 1, 2 }));
    assert Arrays.equals(new int[] { 1, 2, 3, 4 }, BucketSort.sort(new int[] { 4, 3, 2, 1 }));
    assert Arrays.equals(new int[] { 1, 2, 2, 3, 4 }, BucketSort.sort(new int[] { 4, 2, 2, 1, 3 }));
    assert Arrays.equals(new int[] { 1, 2, 3, 6, 9 }, BucketSort.sort(new int[] { 1, 2, 3, 6, 9 }));
  }
  static int[] sort(int[] nums) {
    if (nums.length == 0) return nums;
    int bucketCount = 10;
    ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i<bucketCount; i++) {
      buckets.add(new ArrayList<Integer>());
    }

    for (int i=0; i<nums.length; i++) {
      buckets.get(nums[i]).add(nums[i]);
    }

    int[] sorted = new int[nums.length];
    int i = 0;
    for (int j=0; j<bucketCount; j++) {
      for (int n : buckets.get(j)) {
        sorted[i] = n;
        i++;
      }
    }
    return sorted;
  }
}

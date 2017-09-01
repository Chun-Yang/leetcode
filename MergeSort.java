import java.util.*;

public class MergeSort {
  public static void main (String[] args) {
    MergeSort q = new MergeSort();
    assert Arrays.equals(new int[] {}, q.sort(new int[] {}));
    assert Arrays.equals(new int[] { 1 }, q.sort(new int[] { 1 }));
    assert Arrays.equals(new int[] { 1, 2 }, q.sort(new int[] { 2, 1 }));
    assert Arrays.equals(new int[] { 1, 2, 3, 4 }, q.sort(new int[] { 3, 4, 1, 2 }));
    assert Arrays.equals(new int[] { 1, 2, 3, 4 }, q.sort(new int[] { 4, 3, 2, 1 }));
    assert Arrays.equals(new int[] { 1, 2, 2, 3, 4 }, q.sort(new int[] { 4, 2, 2, 1, 3 }));
    assert Arrays.equals(new int[] { 1, 2, 3, 6, 10 }, q.sort(new int[] { 1, 2, 3, 6, 10 }));
    int n1 = 1000 * 1000 * 10;
    int[] nums1input = new int[n1];
    int[] nums1output = new int[n1];
    for (int i=0; i<n1; i++) {
      nums1input[i] = n1-i-1;
      nums1output[i] = i;
    }
    long t0 = new Date().getTime();
    Arrays.sort(nums1input);
    assert Arrays.equals(nums1output, nums1input);
    long t1 = new Date().getTime();
    System.out.println(t1 - t0);
    assert Arrays.equals(nums1output, q.sort(nums1input));
    long t2 = new Date().getTime();
    System.out.println(t2 - t1);

  }

  public void MergeSort() {
  }

  public int[] sort(int[] nums) {
    sort(nums, 0, nums.length);
    return nums;
  }
  // [start, end)
  private void sort(int[] nums, int start, int end) {
    if (end - start <= 1) return;
    int middle = start + (end - start) / 2;
    sort(nums, start, middle);
    sort(nums, middle, end);
    merge(nums, start, middle, end);
  }
  private void merge(int[] nums, int start, int middle, int end) {
    int leftL = middle - start;
    int rightL = end - middle;
    int[] left = new int[leftL];
    int[] right = new int[rightL];
    for (int i=start; i<middle; i++) {
      left[i - start] = nums[i];
    }
    for (int i=middle; i<end; i++) {
      right[i - middle] = nums[i];
    }
    int leftI = 0;
    int rightI = 0;
    for (int i=start; i<end; i++) {
      if (leftI == leftL) {
        nums[i] = right[rightI];
        rightI++;
      } else if (rightI == rightL) {
        nums[i] = left[leftI];
        leftI++;
      } else if (left[leftI] < right[rightI]) {
        nums[i] = left[leftI];
        leftI++;
      } else {
        nums[i] = right[rightI];
        rightI++;
      }
    }
  }

  private void swap (int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

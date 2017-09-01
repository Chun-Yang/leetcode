import java.util.*;

public class QuickSort {
  public static void main (String[] args) {
    QuickSort q = new QuickSort();
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

  public void QuickSort() {
  }

  public int[] sort(int[] nums) {
    partition(nums, 0, nums.length);
    return nums;
  }

  // three way partition
  private void partition(int[] nums, int start, int end) {
    if (end - start <= 1) return;
    int index = start + (int)(Math.random() * (end - start));
    int pivot = nums[index];
    int smallEnd = start;
    int pivotEnd = start;
    int largeStart = end;
    while (pivotEnd < largeStart) {
      if (nums[pivotEnd] < pivot) {
        swap(nums, smallEnd, pivotEnd);
        smallEnd++;
        pivotEnd++;
      } else if (nums[pivotEnd] > pivot) {
        largeStart--;
        swap(nums, pivotEnd, largeStart);
      } else {
        pivotEnd++;
      }
    }

    partition(nums, start, smallEnd);
    partition(nums, largeStart, end);
  }

  // Put the index at the end, this is inefficient if there are too much duplicate
  // [start, end)
  // private void partition(int[] nums, int start, int end) {
  //   if (end - start <= 1) return;
  //   int index = start + (int)(Math.random() * (end - start));
  //   int value = nums[index];
  //   nums[index] = nums[end - 1];
  //   nums[end - 1] = value;
  //   int endOfSmall = start;
  //   for (int i=start; i<end-1; i++) {
  //     if (nums[i] < value) {
  //       swap(nums, i, endOfSmall);
  //       endOfSmall++;
  //     }
  //   }
  //   nums[end - 1] = nums[endOfSmall];
  //   nums[endOfSmall] = value;
  //   partition(nums, start, endOfSmall);
  //   partition(nums, endOfSmall + 1, end);
  // }

  private void swap (int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

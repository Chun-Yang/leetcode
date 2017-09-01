import java.util.*;

public class CountingSort {
  public static void main (String[] args) {
    assert Arrays.equals(new int[] {}, CountingSort.sort(new int[] {}));
    assert Arrays.equals(new int[] { 1 }, CountingSort.sort(new int[] { 1 }));
    assert Arrays.equals(new int[] { 1, 2 }, CountingSort.sort(new int[] { 2, 1 }));
    assert Arrays.equals(new int[] { 1, 2, 3, 4 }, CountingSort.sort(new int[] { 3, 4, 1, 2 }));
    assert Arrays.equals(new int[] { 1, 2, 3, 4 }, CountingSort.sort(new int[] { 4, 3, 2, 1 }));
    assert Arrays.equals(new int[] { 1, 2, 2, 3, 4 }, CountingSort.sort(new int[] { 4, 2, 2, 1, 3 }));
    assert Arrays.equals(new int[] { 1, 2, 3, 6, 9 }, CountingSort.sort(new int[] { 1, 2, 3, 6, 9 }));
  }
  private CountingSort() {}
  static int[] sort(int[] nums) {
    int[] count = new int[10];
    for (int i=0; i<nums.length; i++) count[nums[i]]++;
    // this saves the end index (exclusive) of the value in the sorted array;
    for (int i=1; i<10; i++) count[i] += count[i-1];
    int[] aux = new int[nums.length];
    for (int i=0; i<nums.length; i++) aux[--count[nums[i]]] = nums[i];
    return aux;
  }
}


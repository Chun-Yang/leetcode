// quick select
// NOTE: for java, Math.random() range is [0, 1)
public class Solution {
  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
  }
  private int quickSelect(int[] nums, int start, int end, int k) {
    if (start == end) return nums[start];

    int pivotIndex = start + (int)(Math.random() * (end - start + 1));
    // put pivot at the end
    int pivotNum = nums[pivotIndex];
    nums[pivotIndex] = nums[end];
    nums[end] = pivotNum;
    // partition
    int smallEnd = start - 1;
    for (int i=start; i<end; i++) {
      if (nums[i] < pivotNum) {
        smallEnd++;
        // swap i and smallEnd
        int temp = nums[i];
        nums[i] = nums[smallEnd];
        nums[smallEnd] = temp;
      }
    }
    // swap end and bigStart
    nums[end] = nums[smallEnd+1];
    nums[smallEnd+1] = pivotNum;
    int n = smallEnd + 2;
    if (n < k) return quickSelect(nums, smallEnd+2, end, k);
    else if (n > k) return quickSelect(nums, start, smallEnd, k);
    else return pivotNum;
  }
}

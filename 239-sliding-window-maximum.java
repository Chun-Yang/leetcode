public class Solution {
  // NOTE:
  // head - - - tail
  // -> index increase
  // -> value decrease
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k <= 1) return nums;
    int[] maxes = new int[nums.length - k + 1];
    Deque<Integer> queue = new LinkedList<>();
    for (int i=0; i<nums.length; i++) {
      // remove all the values that is out of the window
      while (!queue.isEmpty() && queue.peekFirst() <= i - k) queue.pollFirst();
      // remove all the values that is less than current value
      while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) queue.pollLast();
      // put the value at the tail
      queue.offerLast(i);
      // add to maxes
      if (i - k + 1 >= 0) maxes[i-k+1] = nums[queue.peekFirst()];
    }

    return maxes;
  }
}

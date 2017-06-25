public class Solution {
  public List<String> summaryRanges(int[] nums) {
    if (nums.length == 0) return new LinkedList<>();
    int start;
    int end;
    start = end = nums[0];
    List<String> ranges = new LinkedList<String>();
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - end == 1) end++;
      else {
        if (start == end) ranges.add(Integer.toString(start));
        else ranges.add(start + "->" + end);
        start = end = nums[i];
      }
    }
    if (start == end) ranges.add(Integer.toString(start));
    else ranges.add(start + "->" + end);
    return ranges;
  }
}

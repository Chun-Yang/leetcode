import java.util.*;

public class Solution {
  public static void main (String[] args) {
    Solution s = new Solution();
  }
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() <= 1) return intervals;

    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
    Stack<Interval> stack = new Stack<Interval>();
    stack.push(intervals.get(0));

    for (Interval i: intervals) {
      Interval last = stack.peek();
      if (last.end >= i.start) {
        last.end = Math.max(last.end, i.end);
      } else {
        stack.push(i);
      }
    }

    return stack;
  }
}

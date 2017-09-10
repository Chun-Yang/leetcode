// Given a data stream input of non-negative integers a1, a2, ..., an, ...,
// summarize the numbers seen so far as a list of disjoint intervals.

// For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ...,
// then the summary will be:

// [1, 1]
// [1, 1], [3, 3]
// [1, 1], [3, 3], [7, 7]
// [1, 3], [7, 7]
// [1, 3], [6, 7]

// Follow up:
// What if there are lots of merges and the number of disjoint intervals are small
// compared to the data stream's size?

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// Solution 2 for the follow up
// https://discuss.leetcode.com/topic/46887/java-solution-using-treemap-real-o-logn-per-adding/2

// Solution 1
class SummaryRanges {
  List<Interval> intervals;

  /** Initialize your data structure here. */
  public SummaryRanges() {
    intervals = new ArrayList<>();
  }

  public void addNum(int val) {
    for (int i=0; i<intervals.size(); i++) {
      Interval interval = intervals.get(i);
      if (val > interval.end + 1) continue;
      if (val == interval.end + 1) {
        if (i + 1 < intervals.size() && intervals.get(i + 1).start == (val + 1)) {
          // check if we should merge the next one
          interval.end = intervals.get(i + 1).end;
          intervals.remove(i + 1);
        } else {
          // extend current interval
          interval.end = val;
        }
        return;
      }
      if (val >= interval.start) return;
      if (val == interval.start - 1) {
        // extend current interval
        interval.start = val;
        return;
      }
      intervals.add(i, new Interval(val, val));
      return;
    }
    intervals.add(new Interval(val, val));
  }

  public List<Interval> getIntervals() {
    return intervals;
  }
}

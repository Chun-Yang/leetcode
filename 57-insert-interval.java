// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

import java.util.*;

// Solution2: split intervals into three goups: before, overlayps and after
class Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> lefts = new ArrayList<>();
    List<Interval> rights = new ArrayList<>();
    int start = newInterval.start;
    int end = newInterval.end;

    for (Interval i : intervals) {
      if (i.end < start) {
        lefts.add(i);
      } else if (i.start > end) {
        rights.add(i);
      } else {
        start = Math.min(start, i.start);
        end = Math.max(end, i.end);
      }
    }

    List<Interval> all = new ArrayList<>();
    all.addAll(lefts);
    all.add(new Interval(start, end));
    all.addAll(rights);

    return all;
  }

  // public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
  //   List<Interval> merged = new ArrayList<Interval>();
  //   int start = newInterval.start;
  //   int end = newInterval.end;
  //   boolean isMerged = false;
  //   for (Interval i: intervals) {
  //     if (isMerged) merged.add(i);
  //     else if (i.end < start) merged.add(i);
  //     else if (i.start > end) {
  //       merged.add(new Interval(start, end));
  //       merged.add(i);
  //       isMerged = true;
  //     } else {
  //       start = Math.min(start, i.start);
  //       end = Math.max(end, i.end);
  //     }
  //   }
  //   if (!isMerged) merged.add(new Interval(start, end));
  //   return merged;
  // }

  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

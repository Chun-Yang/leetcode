// Median is the middle value in an ordered integer list. If the size of the list
// is even, there is no middle value. So the median is the mean of the two middle
// value.

// Examples:
// [2,3,4] , the median is 3

// [2,3], the median is (2 + 3) / 2 = 2.5

// Design a data structure that supports the following two operations:

// void addNum(int num) - Add a integer number from the data stream to the data structure.
// double findMedian() - Return the median of all elements so far.
// For example:

// addNum(1)
// addNum(2)
// findMedian() -> 1.5
// addNum(3)
// findMedian() -> 2

public class MedianFinder {
  PriorityQueue<Integer> lo; // max queue
  PriorityQueue<Integer> hi; // min queue

  /** initialize your data structure here. */
  public MedianFinder() {
    // lo = new PriorityQueue<>((x, y) -> y - x);
    lo = new PriorityQueue<>(new Comparator<Integer>() {
      public int compare(Integer x, Integer y) {
        return y - x;
      }
    });
    hi = new PriorityQueue<>();
  }

  public void addNum(int num) {
    if (lo.size() == hi.size()) lo.offer(num);
    else hi.offer(num);
    if (hi.size() > 0 && lo.peek() > hi.peek()) {
      int larger = lo.poll();
      int smaller = hi.poll();
      lo.offer(smaller);
      hi.offer(larger);
    }
  }

  public double findMedian() {
    if (lo.size() == hi.size()) return (lo.peek() + hi.peek()) / 2.0;
    return lo.peek();
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

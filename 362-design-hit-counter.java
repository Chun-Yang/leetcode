// Design a hit counter which counts the number of hits received in the past 5 minutes.

// Each function accepts a timestamp parameter (in seconds granularity) and you
// may assume that calls are being made to the system in chronological order
// (ie, the timestamp is monotonically increasing). You may assume that the
// earliest timestamp starts at 1.

// It is possible that several hits arrive roughly at the same time.

// Example:
// HitCounter counter = new HitCounter();

// // hit at timestamp 1.
// counter.hit(1);

// // hit at timestamp 2.
// counter.hit(2);

// // hit at timestamp 3.
// counter.hit(3);

// // get hits at timestamp 4, should return 3.
// counter.getHits(4);

// // hit at timestamp 300.
// counter.hit(300);

// // get hits at timestamp 300, should return 4.
// counter.getHits(300);

// // get hits at timestamp 301, should return 3.
// counter.getHits(301);
// Follow up:
// What if the number of hits per second could be very large? Does your design scale?

// https://discuss.leetcode.com/topic/48758/super-easy-design-o-1-hit-o-s-gethits-no-fancy-data-structure-is-needed/2

class HitCounter {
  int[] times;
  int[] hits;
  static final int SECONDS = 600;

  public HitCounter() {
    times = new int[HitCounter.SECONDS];
    hits = new int[HitCounter.SECONDS];
  }

  public void hit(int timestamp) {
    int index = timestamp % HitCounter.SECONDS;
    if (times[index] == timestamp) {
      hits[index]++;
    } else {
      times[index] = timestamp;
      hits[index] = 1;
    }
  }

  public int getHits(int timestamp) {
    int hits = 0;
    for (int i=0; i<HitCounter.SECONDS; i++) {
      if (times[i] >= timestamp - HitCounter.SECONDS) hits+=times[i];
    }
    return hits;
  }
}

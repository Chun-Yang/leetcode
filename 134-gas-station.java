// There are N gas stations along a circular route, where the amount of gas at
// station i is gas[i].
//
//
//
// You have a car with an unlimited gas tank and it costs cost[i] of gas to
// travel from station i to its next station (i+1). You begin the journey with
// an empty tank at one of the gas stations.
//
//
//
// Return the starting gas station's index if you can travel around the circuit
// once, otherwise return -1.
//
//
//
// Note:
// The solution is guaranteed to be unique.


// https://leetcode.com/problems/gas-station

// solution1 two pass
// - find the remaining one that is positive till the end
// - use that index to see if we can go back to its self

class Solution {
  // invariant: total >= 0
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int index = 0;
    int total = 0;
    for (int i=0; i<n; i++) {
      total += gas[i] - cost[i];
      if (total < 0) {
        index = i + 1;
        total = 0;
      }
    }
    if (index == n) {
      return -1;
    }
    total = 0;
    for (int i=0; i<n; i++) {
      int j = (i + index) % n;
      total += gas[j] - cost[j];
      if (total < 0) {
        return -1;
      }
    }
    return index;
  }
}

// solution2 one pass
// - save the total, if total is not negative, then it's guaranteed to
// make a circle

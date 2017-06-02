public class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0;
    int total = 0;
    int tank = 0;
    int length = gas.length;
    for (int i=0; i < length; i++) {
      total += gas[i] - cost[i];

      tank += gas[i] - cost[i];
      if (tank < 0) {
        start = i + 1;
        tank = 0;
      }
    }
    return total >= 0 ? start : -1;
  }
}
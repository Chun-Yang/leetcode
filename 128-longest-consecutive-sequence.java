public class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;

    Set<Integer> set = new HashSet<Integer>();
    for(int num: nums) set.add(num);

    int best = 1;
    for (int start: nums) {
      if (!set.contains(start-1)) {
        int end = start + 1;
        while (set.contains(end)) {
          end++;
          best = Math.max(best, end - start);
        }
      }
    }
    return best;
  }

  // public int longestConsecutive(int[] nums) {
  //   HashMap<Integer, Integer> starts = new HashMap<Integer, Integer>();
  //   HashMap<Integer, Integer> ends = new HashMap<Integer, Integer>();
  //   for (int num: nums) {
  //     if (starts.containsKey(num) || ends.containsKey(num)) {
  //       continue;
  //     } else if (starts.containsKey(num + 1) && ends.containsKey(num - 1)) {
  //       int start = ends.get(num - 1);
  //       int end = starts.get(num + 1);
  //       starts.remove(num + 1);
  //       starts.remove(start);
  //       ends.remove(end);
  //       ends.remove(num - 1);
  //       starts.put(start, end);
  //       ends.put(end, start);
  //     } else if (starts.containsKey(num + 1)) {
  //       int end = starts.get(num + 1);
  //       starts.remove(num + 1);
  //       starts.put(num, end);
  //       ends.put(end, num);
  //     } else if (ends.containsKey(num - 1)) {
  //       int start = ends.get(num - 1);
  //       ends.remove(num - 1);
  //       ends.put(num, start);
  //       starts.put(start, num);
  //     } else {
  //       starts.put(num, num);
  //       ends.put(num, num);
  //     }
  //   }

  //   int length = 0;
  //   for (int start: starts.keySet()) {
  //     length = Math.max(length, starts.get(start) - start + 1);
  //   }
  //   return length;
  // }
}

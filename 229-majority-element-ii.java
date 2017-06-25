// https://discuss.leetcode.com/topic/17564/boyer-moore-majority-vote-algorithm-and-my-elaboration
// search liji94188
// The majoriteis protect each other
// https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html

public class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int[] tops = new int[]{ 0, 1 };
    int[] counts = new int[2];
    // get tops
    for (int num: nums) {
      if (num == tops[0]) counts[0]++;
      else if (num == tops[1]) counts[1]++;
      else if (counts[0] == 0) {
        tops[0] = num;
        counts[0]++;
      } else if (counts[1] == 0) {
        tops[1] = num;
        counts[1]++;
      } else {
        counts[0]--;
        counts[1]--;
      }
    }

    // check tops
    List<Integer> majors = new ArrayList<>();
    for (int i=0; i<2; i++) {
      int total = 0;
      for (int num : nums) {
        if (tops[i] == num) total++;
      }
      if (total > nums.length / 3) majors.add(tops[i]);
    }

    return majors;
  }
}

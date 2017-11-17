// Given an integer n, return 1 - n in lexicographical order.

// For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

// Please optimize your algorithm to use less time and space. The input size may
// be as large as 5,000,000.

// solution1: O(n * log(n)) sort by number
import java.util.*;

// class Solution {
//   public List<Integer> lexicalOrder(int n) {
//     String[] nums = new String[n];
//     for (int i=1; i<=n; i++) nums[i-1] = Integer.toString(i);
//     Arrays.sort(nums);
//     List<Integer> list = new ArrayList<Integer>();
//     for (int i=1; i<=n; i++) {
//       list.add(Integer.parseInt(nums[i-1]));
//     }
//     return list;
//   }
// }

// solution2: O(n) bfs
class Solution {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i=1; i<=9; i++) {
      dfs(i, n, list);
    }
    return list;
  }
  private void dfs(int num, int limit, List<Integer> list) {
    if (num > limit) return;
    list.add(num);
    for (int i=0; i<10; i++) {
      dfs(num * 10 + i, limit, list);
    }
  }
}

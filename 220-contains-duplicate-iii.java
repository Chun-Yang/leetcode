public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeMap<Long, Integer> tree = new TreeMap<>();
    for (int i=0; i<nums.length; i++) {
      if (i > k) tree.remove((long)nums[i-k-1]);
      long num = (long) nums[i];
      Long lo = tree.floorKey(num);
      if (lo != null && num - lo <= t) return true;
      Long hi = tree.ceilingKey(num);
      if (hi != null && hi - num <= t) return true;
      tree.put(num, i);
    }
    return false;
  }
}

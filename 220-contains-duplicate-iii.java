public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (t < 0 || k <=0 ) return false;
    HashMap<Long, Long> buckets = new HashMap<>();
    for (int i=0; i<nums.length; i++) {
      // check if match found
      long normalizedNum = (long)nums[i] - Integer.MIN_VALUE;
      long bucket = normalizedNum / ((long)t + 1);
      if (
          buckets.containsKey(bucket) ||
          (buckets.containsKey(bucket - 1) && normalizedNum - buckets.get(bucket-1) <= t) ||
          (buckets.containsKey(bucket + 1) && buckets.get(bucket+1) - normalizedNum <= t)
          ) return true;
      // add number
      buckets.put(bucket, normalizedNum);
      // remove number
      if (i >= k) buckets.remove(((long) nums[i-k] - Integer.MIN_VALUE) / ((long) t + 1));
    }
    return false;
  }
  // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
  //   TreeMap<Long, Integer> tree = new TreeMap<>();
  //   for (int i=0; i<nums.length; i++) {
  //     if (i > k) tree.remove((long)nums[i-k-1]);
  //     long num = (long) nums[i];
  //     Long lo = tree.floorKey(num);
  //     if (lo != null && num - lo <= t) return true;
  //     Long hi = tree.ceilingKey(num);
  //     if (hi != null && hi - num <= t) return true;
  //     tree.put(num, i);
  //   }
  //   return false;
  // }
}

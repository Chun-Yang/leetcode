public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashSet<Integer> existing = new HashSet<>();
    for (int i=0; i<nums.length; i++) {
      if (i - k > 0) existing.remove(nums[i-k-1]);
      if (existing.contains(nums[i])) return true;
      existing.add(nums[i]);
    }
    return false;
  }
}

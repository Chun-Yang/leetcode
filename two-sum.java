import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i=0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[] {map.get(target - nums[i]), i};
      } else {
        map.put(nums[i], i);
      }
    }

    return new int[] {0, 0};
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    assert Arrays.equals(
        s.twoSum(new int[]{0,1,2,4,7}, 5),
        new int[]{1, 3}
        );
  }
}

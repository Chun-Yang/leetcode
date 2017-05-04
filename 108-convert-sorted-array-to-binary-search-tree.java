import java.util.*;

public class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    return toBst(nums, 0, nums.length);
  }
  private TreeNode toBst(int[] nums, int start, int end) {
    if (start == end) return null;

    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = toBst(nums, start, mid);
    root.right = toBst(nums, mid + 1, end);
    return root;
  }
}

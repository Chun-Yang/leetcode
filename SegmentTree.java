import java.util.*;

// maximum range update and query
public class SegmentTree {
  public static void main (String[] args) {
    SegmentTree s = new SegmentTree(new int[]{ 0, 2, 9, 8, 2, 1 });
    assert s.max(0, 3) == 9;
    assert s.max(4, 5) == 2;
    s.update(0, 10);
    assert s.max(0, 3) == 10;
    assert s.max(0, 5) == 10;
  }
  int[] tree;
  int n;
  public SegmentTree(int[] nums) {
    n = nums.length;
    tree = new int[2 * n];
    for (int i=n; i<2*n; i++) {
      tree[i] = nums[i - n];
    }
    for (int i=n-1; i>0; i--) {
      tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
    }
  }
  public int max(int start, int end) {
    start += n;
    end += n;
    int maxValue = Integer.MIN_VALUE;
    while (start <= end) {
      if (start % 2 == 1) {
        maxValue = Math.max(maxValue, tree[start]);
        start++;
      }
      if (end % 2 == 0) {
        maxValue = Math.max(maxValue, tree[end]);
        end--;
      }
      start /= 2;
      end /= 2;
    }
    return maxValue;
  }
  public void update(int index, int value) {
    int i = index + n;
    tree[i] = value;
    while (i > 1) {
      int left = i % 2 == 0 ? i : i - 1;
      int right = i % 2 == 0 ? i + 1: i;
      i /= 2;
      tree[i] = Math.max(tree[left], tree[right]);
    }
  }
}

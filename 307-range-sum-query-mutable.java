// Given an integer array nums, find the sum of the elements between
// indices i and j (i ≤ j), inclusive.

// The update(i, val) function modifies nums by updating the element at
// index i to val. Example: Given nums = [1, 3, 5]

// sumRange(0, 2) -> 9 update(1, 2) sumRange(0, 2) -> 8
// Note: The array is only modifiable by the update function. You may assume
// the number of calls to update and sumRange function is distributed evenly.



/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

// Solution 2 Segment Tree
class NumArray {
  int n;
  int[] tree;

  public NumArray(int[] nums) {
    n = nums.length;
    if (n == 0) return;

    tree = new int[2 * n];
    for (int i=0; i<n; i++) tree[n + i] = nums[i];
    for (int i=n-1; i>0; i--) tree[i] = tree[i*2] + tree[i*2 + 1];
  }

  public void update(int i, int val) {
    i += n;
    tree[i] = val;
    while (i > 0) {
      int left = i;
      int right = i;
      if (i % 2 == 0) right++;
      else left--;
      i /= 2;
      tree[i] = tree[left] + tree[right];
    }
  }

  public int sumRange(int i, int j) {
    i += n;
    j += n;

    int sum = 0;
    while (i <= j) {
      if (i % 2 == 1) {
        sum += tree[i];
        i++;
      }
      if (j % 2 == 0) {
        sum += tree[j];
        j--;
      }
      i /= 2;
      j /= 2;
    }

    return sum;
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

// https://cs.stackexchange.com/questions/10538/bit-what-is-the-intuition-behind-a-binary-indexed-tree-and-how-was-it-thought-a

// Solution 1 Binary Indexed Tree
// import java.util.*;

// class NumArray {
//   int[] bit;
//   int[] nums;
//   int maxIndex;

//   public NumArray(int[] nums) {
//     maxIndex = nums.length;
//     this.nums = new int[maxIndex];
//     bit = new int[maxIndex + 1];
//     for (int i=0; i<maxIndex; i++) update(i, nums[i]);
//   }

//   public void update(int i, int val) {
//     int index = i + 1;
//     int change = val - nums[i];
//     nums[i] = val;
//     while (index <= maxIndex) {
//       bit[index] += change;
//       index += (index & -index);
//     }
//   }

//   public int sumRange(int i, int j) {
//     return sumLeft(j) - sumLeft(i - 1);
//   }

//   private int sumLeft(int i) {
//     int sum = 0;
//     int index = i + 1;
//     while (index > 0) {
//       sum += bit[index];
//       index -= (index & -index);
//     }
//     return sum;
//   }
// }

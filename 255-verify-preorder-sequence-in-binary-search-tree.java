// Check if a given array can represent Preorder Traversal of Binary Search Tree
// Given an array of numbers, return true if given array can represent
// preorder traversal of a Binary Search Tree, else return false.
// Expected time complexity is O(n).

// Examples:

// Input:  pre[] = {2, 4, 3}
// Output: true
// Given array can represent preorder traversal
// of below tree
//     2
//      \
//       4
//      /
//     3

// Input:  pre[] = {2, 4, 1}
// Output: false
// Given array cannot represent preorder traversal
// of a Binary Search Tree.

// Input:  pre[] = {40, 30, 35, 80, 100}
// Output: true
// Given array can represent preorder traversal
// of below tree
//      40
//    /   \
//  30    80
//   \      \
//   35     100


// Input:  pre[] = {40, 30, 35, 20, 80, 100}
// Output: false
// Given array cannot represent preorder traversal
// of a Binary Search Tree.

// solution1: dfs resursive
class Solution {
  int[] pre;
  int index;
  int length;
  public boolean verify(int[] pre) {
    index = 0;
    length = pre.length;
    this.pre = pre;
    return check(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  private boolean check(int minLimit, int maxLimit) {
    if (index == length) {
      return true;
    }
    int current = pre[index];
    if (current <= minLimit || current >= maxLimit) {
      return false;
    }
    index++;
    return check(minLimit, current) || check(current, maxLimit);
  }

  public static void main(String[] args) {
    assert new Solution().verify(new int[] { 2, 4, 3 }) == true;
    assert new Solution().verify(new int[] { 2, 4, 1 }) == false;
    assert new Solution().verify(new int[] { 40, 30, 35, 80, 100 }) == true;
    assert new Solution().verify(new int[] { 40, 30, 35, 20, 80, 100 }) == false;
  }
}

// Given a binary tree, collect a tree's nodes as if you were doing this:
// Collect and remove all leaves, repeat until the tree is empty.

// Example:
// Given binary tree

//           1
//          / \
//         2   3
//        / \
//       4   5
// Returns [4, 5, 3], [2], [1].

// Solution1: find max depth, create an array and use the current depth
// to position the element in the array

class Solution {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> leaves = new ArrayList<>();
    postOrder(leaves, root);
    return leaves;
  }
  private int postOrder(List<List<Integer>> leaves, TreeNode node) {
    if (node == null) return -1;
    int leftIndex = postOrder(leaves, node.left);
    int rightIndex = postOrder(leaves, node.right);
    int curIndex = Math.max(leftIndex, rightIndex) + 1;
    if (curIndex == leaves.size()) {
      leaves.add(new ArrayList<Integer>());
    }
    leaves.get(curIndex).add(node.val);
    return curIndex;
  }
}

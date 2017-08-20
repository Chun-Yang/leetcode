// In Binary Tree, Inorder successor of a node is the next node in Inorder
// traversal of the Binary Tree. Inorder Successor is NULL for the last node in
// Inoorder traversal. In Binary Search Tree, Inorder Successor of an input node
// can also be defined as the node with the smallest key greater than the key of
// input node. So, it is sometimes important to find next node in sorted order.

//             20
//           /    \
//          8      22
//       /    \
//      4      12
//           /    \
//         10      14

// In the above diagram, inorder successor of 8 is 10, inorder successor of 10 is
// 12 and inorder successor of 14 is 20.

// https://discuss.leetcode.com/topic/25076/share-my-java-recursive-solution










class Node {
  Node left;
  Node right;
  int val;
}

class Solution {
  Node inOrderSuccessor(Node root, Node n) {
    if (root == null) return null;
    if (root.val <= n.val) {
      return inOrderSuccessor(root.right, n);
    } else {
      Node succ = inOrderSuccessor(root.left, n);
      return succ == null ? n : succ;
    }
  }
}


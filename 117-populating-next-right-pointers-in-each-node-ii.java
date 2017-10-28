// Follow up for problem "Populating Next Right Pointers in Each Node".
// What if the given tree could be any binary tree? Would your previous
// solution still work?
//
// Note:
// You may only use constant extra space.
//
//
// For example,
// Given the following binary tree,
//
// 1
// /  \
// 2    3
// / \    \
// 4   5    7
//
//
//
// After calling your function, the tree should look like:
//
// 1 -> NULL
// /  \
// 2 -> 3 -> NULL
// / \    \
// 4-> 5 -> 7 -> NULL


// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

// solution1: dfs
// passdown the parent, find the next one
// class Solution {
//   public void connect(TreeLinkNode root) {
//     dfs(new TreeLinkNode(0), root, false);
//   }
//   private void dfs(TreeLinkNode parent, TreeLinkNode current, boolean isLeft) {
//     if (current == null) {
//       return;
//     }
//     if (isLeft && parent.right != null) {
//       current.next = parent.right;
//     } else {
//       parent = parent.next;
//       while(parent != null) {
//         if (parent.left != null) {
//           current.next = parent.left;
//           break;
//         } else if (parent.right != null) {
//           current.next = parent.right;
//           break;
//         }
//         parent = parent.next;
//       }
//     }
//     dfs(current, current.right, false);
//     dfs(current, current.left, true);
//   }
// }

// solution2: bfs and linked list pointer
class Solution {
  public void connect(TreeLinkNode root) {
    TreeLinkNode parent = root;
    while (parent != null) {
      TreeLinkNode child = null;
      TreeLinkNode nextParent = null;
      while(parent != null) {
        if (parent.left != null) {
          if (child == null) {
            nextParent = parent.left;
          } else {
            child.next = parent.left;
          }
          child = parent.left;
        }
        if (parent.right != null) {
          if (child == null) {
            nextParent = parent.right;
          } else {
            child.next = parent.right;
          }
          child = parent.right;
        }
        parent = parent.next;
      }
      parent = nextParent;
    }
  }
}

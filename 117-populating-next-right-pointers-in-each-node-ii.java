/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// https://discuss.leetcode.com/topic/1106/o-1-space-o-n-complexity-iterative-solution/6
// https://discuss.leetcode.com/topic/8447/simple-solution-using-constant-space
public class Solution {
  public void connect(TreeLinkNode root) {
    TreeLinkNode upperHead = root;
    TreeLinkNode lowerHat = new TreeLinkNode(0);
    while (upperHead != null) {
      lowerHat.next = null;
      TreeLinkNode lowerIter = lowerHat;
      while (upperHead != null) {
        if (upperHead.left != null) {
          lowerIter.next = upperHead.left;
          lowerIter = lowerIter.next;
        }
        if (upperHead.right != null) {
          lowerIter.next = upperHead.right;
          lowerIter = lowerIter.next;
        }
        upperHead = upperHead.next;
      }
      upperHead = lowerHat.next;
    }
  }

  // public void connect(TreeLinkNode root) {
  //   TreeLinkNode upperHead = root;
  //   TreeLinkNode lowerHat = new TreeLinkNode(0);
  //   while (upperHead != null) {
  //     lowerHat.next = null;
  //     TreeLinkNode lowerIter = lowerHat;
  //     while (upperHead != null) {
  //       if (upperHead.left != null) {
  //         lowerIter.next = upperHead.left;
  //         lowerIter = lowerIter.next;
  //       }
  //       if (upperHead.right != null) {
  //         lowerIter.next = upperHead.right;
  //         lowerIter = lowerIter.next;
  //       }
  //       upperHead = upperHead.next;
  //     }
  //     upperHead = lowerHat.next;
  //   }
  // }
  // public void connect(TreeLinkNode root) {
  //   if (root == null) return;

  //   Queue<TreeLinkNode> level = new ArrayDeque<>();
  //   level.offer(root);
  //   while (!level.isEmpty()) {
  //     int size = level.size();
  //     TreeLinkNode cur = new TreeLinkNode(0);
  //     for (int i=0; i<size; i++) {
  //       cur.next = level.poll();
  //       cur = cur.next;
  //       if (cur.left != null) level.offer(cur.left);
  //       if (cur.right != null) level.offer(cur.right);
  //     }
  //   }
  // }
}

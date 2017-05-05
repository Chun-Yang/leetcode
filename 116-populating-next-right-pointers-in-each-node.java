/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    connectTo(root, null);
  }
  private void connectTo(TreeLinkNode root, TreeLinkNode next) {
    if (root == null) return;
    root.next = next;
    connectTo(root.left, root.right);
    connectTo(root.right, next == null ? null : next.left);
  }
}

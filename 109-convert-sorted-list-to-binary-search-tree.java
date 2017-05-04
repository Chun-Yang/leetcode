/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  // public class ListNode {
  //   int val;
  //   ListNode next;
  //   ListNode(int x) { val = x; }
  // }
  // public class TreeNode {
  //   int val;
  //   TreeNode left;
  //   TreeNode right;
  //   TreeNode(int x) { val = x; }
  // }

  private class TreeAndListNodes {
    TreeNode treeNode;
    ListNode listNode;
    TreeAndListNodes(TreeNode t, ListNode l) {
      treeNode = t;
      listNode = l;
    }
  }

  public TreeNode sortedListToBST(ListNode head) {
    ListNode node = head;
    int size = 0;
    while (node != null) {
      node = node.next;
      size++;
    }
    return toBST(head, size).treeNode;
  }

  // return [tree, root of the current tree]
  private TreeAndListNodes toBST(ListNode head, int size) {
    if (size == 0) return new TreeAndListNodes(null, head);
    if (size == 1) return new TreeAndListNodes(new TreeNode(head.val), head.next);
    int leftSize = size / 2;

    TreeAndListNodes leftNodes = toBST(head, leftSize);

    TreeNode root = new TreeNode(leftNodes.listNode.val);
    root.left = leftNodes.treeNode;

    // NOTE: we can deal with size 0 here
    TreeAndListNodes rightNodes = toBST(leftNodes.listNode.next, size - leftSize - 1);
    root.right = rightNodes.treeNode;

    return new TreeAndListNodes(root, rightNodes.listNode);
  }
}

public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode hat = new ListNode(0);
    hat.next = head;
    ListNode slow = hat;
    for (int i=0; i<m-1; i++) slow = slow.next;
    ListNode fast = slow.next;
    for (int i=0; i<n-m; i++) {
      ListNode next = fast.next;
      fast.next = next.next;
      next.next = slow.next;
      slow.next = next;
    }
    return hat.next;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

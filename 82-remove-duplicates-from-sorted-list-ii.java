public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    boolean isDup = false;
    ListNode hat = new ListNode(0);
    ListNode hatCur = hat;
    ListNode cur = head;
    while (cur != null) {
      if (cur.next != null && cur.val == cur.next.val) {
        isDup = true;
      } else if (isDup) {
        isDup = false;
      } else {
        hatCur.next = cur;
        hatCur = hatCur.next;
      }
      cur = cur.next;
    }
    hatCur.next = null;
    return hat.next;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

import java.util.Arrays;

public class Solution {
  // public class ListNode {
  //   int val;
  //   ListNode next;
  //   ListNode(int x) { val = x; }
  // }

  public ListNode partition(ListNode head, int x) {
    ListNode hat = new ListNode(0);
    hat.next = head;
    ListNode lessThanEnd = hat;
    ListNode largerThanEnd = hat;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val >= x) {
        largerThanEnd = cur;
        cur = cur.next;
      } else if (lessThanEnd.next == cur) {
        lessThanEnd = cur;
        cur = cur.next;
      } else {
        ListNode nextLessThanEnd = cur;
        cur = cur.next;
        nextLessThanEnd.next = lessThanEnd.next;
        lessThanEnd.next = nextLessThanEnd;
        lessThanEnd = nextLessThanEnd;
        largerThanEnd.next = cur;
      }
    }

    return hat.next;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
  }
}

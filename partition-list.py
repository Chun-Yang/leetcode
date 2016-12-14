class Solution(object):
    def partition(self, head, x):
        # create two linked list: lz and ge
        lzTail, geTail = lzHead, geHead = ListNode(0), ListNode(0)

        # split input into these two list
        while head:
            if head.val < x:
                lzTail.next, lzTail = head, head
            else:
                geTail.next, geTail = head, head
            head = head.next

        # concatenate the two list, make sure None is at the end of the list
        lzTail.next, geTail.next = geHead.next, None

        return lzHead.next

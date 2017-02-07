# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
from random import randrange

class Solution(object):

    def __init__(self, head):
        """
        @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node.
        :type head: ListNode
        """
        self.size = 0
        self.head = head

        node = head
        while node:
            self.size += 1
            node = node.next

    def getRandom(self):
        """
        Returns a random node's value.
        :rtype: int
        """
        count = randrange(0, self.size)
        node = self.head
        for i in range(count):
            node = node.next
        return node.val


# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()

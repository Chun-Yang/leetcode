# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from heapq import heappush, heappop

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        hat = ListNode(0)
        heap = []
        nodes = lists[:]
        for i, head in enumerate(nodes):
            if head:
                heappush(heap, [head.val, i])
                nodes[i] = head.next

        node = hat
        while heap:
            val, i = heappop(heap)
            node.next = ListNode(val)
            node = node.next
            if nodes[i]:
                heappush(heap, [nodes[i].val, i])
                nodes[i] = nodes[i].next

        return hat.next

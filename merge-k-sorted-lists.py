# O(n * log(N)) N is the number of lists

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from heapq import heappush, heappop

class NodeHeap():
    def __init__(self):
        self.heap = []

    def push(self, node):
        heappush(self.heap, (node.val, node))

    def pop(self):
        return heappop(self.heap)[1]

    def isEmpty(self):
        return len(self.heap) == 0

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        # assuming all nodes have values
        heap = NodeHeap()
        for l in lists:
            if l:
                heap.push(l)

        if heap.isEmpty():
            return []

        merged_first = heap.pop()
        merged_last = merged_first

        while (not heap.isEmpty()):
            if not (merged_last.next is None):
                heap.push(merged_last.next)
            next_node = heap.pop()
            merged_last.next = next_node
            merged_last = next_node

        return merged_first

# assert Solution().mergeKLists([[]]) == []

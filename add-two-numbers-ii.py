# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        def listToNum(node, previous=0):
            if node.next is None:
                return previous * 10 + node.val
            return listToNum(node.next, previous * 10 + node.val)

        def numToList(num):
            num, val = divmod(num, 10)
            node = ListNode(val)
            if num == 0:
                return (node, node)
            first, last = numToList(num)
            last.next = node
            return (first, node)

        n1, n2 = listToNum(l1), listToNum(l2)
        return numToList(n1 + n2)[0]

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        hat = ListNode(0)
        hat.next = head
        curHat = hat

        def reverseK(curHat):
            curHead = curHat.next
            for i in range(k-1):
                preHead = curHat.next
                curHat.next = curHead.next
                curHead.next = curHead.next.next
                curHat.next.next = preHead
            return curHead

        while True:
            # count
            countNode = curHat.next
            for i in range(k):
                if not countNode:
                    return hat.next
                else:
                    countNode = countNode.next

            # reverse
            curHat = reverseK(curHat)

def listToListNodes(nums):
    hat = ListNode(0)
    node = hat
    for num in nums:
        node.next = ListNode(num)
        node = node.next
    return hat.next

def listNodesToList(head):
    nums = []
    while head:
        nums.append(head.val)
        head = head.next
    return nums

assert [1,2,3,4,5] == listNodesToList(listToListNodes([1,2,3,4,5]))

def reverseListNodes(head):
    hat = ListNode(0)
    while head:
        head, hat.next, hat.next.next = head.next, head, hat.next
    return hat.next

assert [5,4,3,2,1] == listNodesToList(reverseListNodes(listToListNodes([1,2,3,4,5])))
assert [] == listNodesToList(reverseListNodes(listToListNodes([])))

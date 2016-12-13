class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # find the length of the list
        l = 0
        node = head
        while node:
            l += 1
            node = node.next

        def merge(hat, groupSize, listSize):
            mergedSize = 0
            head, tail = hat, hat.next
            while mergedSize < listSize:
                leftSize = min(listSize - mergedSize, groupSize // 2)
                rightSize = max(
                        0,
                        min(
                            listSize - mergedSize - groupSize // 2,
                            groupSize // 2
                            )
                        )
                left, right = tail, tail

                for i in range(leftSize):
                    right = right.next

                for i in range(leftSize + rightSize):
                    tail = tail.next

                leftMove, rightMove = 0, 0
                while True:
                    if leftMove == leftSize and rightMove == rightSize:
                        break
                    shouldGetLeft = (rightMove == rightSize) or \
                        (leftMove < leftSize and left.val < right.val)
                    if shouldGetLeft:
                        head.next = left
                        left = left.next
                        leftMove += 1
                    else:
                        head.next = right
                        right = right.next
                        rightMove += 1
                    head = head.next

                head.next = None
                mergedSize += (leftSize + rightSize)

        hat = ListNode(0)
        hat.next = head
        groupSize = 2
        while groupSize < 2 * l:
            merge(hat, groupSize, l)
            groupSize *= 2

        return hat.next

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

def numsToList(nums):
    if not nums:
        return None
    node = ListNode(nums[0])
    node.next = numsToList(nums[1:])
    return node

def listToNums(head):
    if not head:
        return []
    return [head.val] + listToNums(head.next)

# nums = listToNums(numsToList([1,2,3,4]))
nums = listToNums(Solution().sortList(numsToList([5,2,3,4,1])))
print("nums", nums)

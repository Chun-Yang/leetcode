class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """

        if not head:
            return None

        # copy the list
        headCopy = RandomListNode(head.label)
        headNext, headCopyNext = head, headCopy
        while headNext.next:
            headNext = headNext.next
            headCopyNext.next = RandomListNode(headNext.label)
            headCopyNext = headCopyNext.next

        # create two list to put the objects in
        linkedList = [head]
        headNext = head
        while headNext.next:
            headNext = headNext.next
            linkedList.append(headNext)

        linkedListCopy = [headCopy]
        headNextCopy = headCopy
        while headNextCopy.next:
            headNextCopy = headNextCopy.next
            linkedListCopy.append(headNextCopy)

        # change the labels for the orgin list to use its won index
        headNext = head
        index = 0
        while headNext:
            headNext.label = index
            index += 1
            headNext = headNext.next

        # use the index to track random
        for i in range(len(linkedList)):
            randomNode = linkedList[i].random
            if randomNode:
                linkedListCopy[i].random = linkedListCopy[randomNode.label]
            else:
                linkedListCopy[i].random = None

        for i in range(len(linkedList)):
            linkedList[i].label = linkedListCopy[i].label

        return headCopy

# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

# x = RandomListNode(1)
# y = {}
# y[x] = 1
# v = y[RandomListNode(1)].label
# print("v", v)

# def linkedList(array):
#     if not array:
#         return None
#     node = RandomListNode(array[0])
#     node.next = linkedList(array[1:])
#     return node

# Solution().copyRandomList(linkedList([1,2,3]))

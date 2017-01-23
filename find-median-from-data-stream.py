from heapq import heappush, heappop

class MedianFinder(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.maxStack = []
        self.minStack = []
        self.middle = None

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        if self.middle is None:
            self.middle = num
            return
        if num > self.middle:
            heappush(self.minStack, num)
            if len(self.minStack) - len(self.maxStack) == 2:
                heappush(self.maxStack, - self.middle)
                self.middle = heappop(self.minStack)
        else:
            heappush(self.maxStack, - num)
            if len(self.maxStack) - len(self.minStack) == 2:
                heappush(self.minStack, self.middle)
                self.middle = - heappop(self.maxStack)

    def findMedian(self):
        """
        :rtype: float
        """
        leftCount, rightCount = len(self.maxStack), len(self.minStack)
        if leftCount < rightCount:
            return (self.middle + self.minStack[0]) / 2.0
        elif leftCount > rightCount:
            return (self.middle - self.maxStack[0]) / 2.0
        else:
            return self.middle

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()

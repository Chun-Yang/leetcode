class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.ancestors = [[[NestedInteger()] + nestedList, 0]]
        self.next()

    def next(self):
        """
        :rtype: int
        """
        # get current value
        curList, index = self.ancestors[-1]
        value = curList[index].getInteger()

        # move to next value or empty ancestors stack
        self.ancestors[-1][1] += 1
        curList, index = self.ancestors[-1]

        while True:
            if index == len(curList):
                self.ancestors.pop()
                if self.ancestors:
                    self.ancestors[-1][1] += 1
                    curList, index = self.ancestors[-1]
                else:
                    break
            elif curList[index].isInteger():
                break
            else:
                curList, index = curList[index].getList(), 0
                self.ancestors.append([curList, index])

        return value

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.ancestors) > 0


# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())

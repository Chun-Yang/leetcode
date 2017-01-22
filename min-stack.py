class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.values = []
        self.mins = []

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.values.append(x)
        if self.mins:
            self.mins.append(min(self.mins[-1], x))
        else:
            self.mins.append(x)

    def pop(self):
        """
        :rtype: void
        """
        value = self.values.pop()
        self.mins.pop()
        return value


    def top(self):
        """
        :rtype: int
        """
        return self.values[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.mins[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

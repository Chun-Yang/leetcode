# import sys
# sys.setrecursionlimit(10)

class Solution(object):
    def getSum(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        def s(a, b):
            print("a, b", a, b)
            if b == 0:
                return a
            else:
                return s(a^b, (a&b) << 1)

        return s(a, b)

# x = Solution().getSum(-1, 1)
# print("x", x)

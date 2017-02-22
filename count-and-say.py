class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        curSequence = [1]

        for i in range(n - 1):
            nextSequence = []
            size = len(curSequence)
            index = 0

            while index < size:
                curIndex = index
                value = curSequence[index]
                while index < size and value == curSequence[index]:
                    index += 1
                nextSequence.append(index - curIndex)
                nextSequence.append(value)

            curSequence = nextSequence

        return ''.join(str(i) for i in curSequence)

# Solution().countAndSay(20)

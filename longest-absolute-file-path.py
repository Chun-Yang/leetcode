class Solution(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        maxLength = 0

        lengths = []
        level = -1
        for p in input.split('\n'):
            curLevel = 0
            while p[curLevel] == "\t":
                curLevel += 1
            curLength = len(p) - curLevel

            for i in range(max(level - curLevel + 1, 0)):
                lengths.pop()

            lengths.append(curLength)
            level = curLevel

            if p.find('.') > -1:
                absLength = sum(lengths) + len(lengths) - 1
                maxLength = max(absLength, maxLength)

        return maxLength

# Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext")

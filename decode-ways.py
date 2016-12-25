class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        size = len(s)
        if size == 0:
            return 0

        counts = [0] * size
        counts[-1] = int(s[-1] != '0')
        if size == 1:
            return counts[-1]

        for i in reversed(range(size - 1)):
            if s[i] != '0':
                counts[i] += counts[i + 1]
                canBeDouble = int(s[i:i+2]) <= 26
                if canBeDouble:
                    if i + 2 == size:
                        counts[i] += 1
                    else:
                        counts[i] += counts[i + 2]

        return counts[0]

# Solution().numDecodings('10')

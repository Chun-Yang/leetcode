class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s

        rows = [[] for i in range(numRows)]
        period = 2 * numRows - 2
        for i, c in enumerate(s):
            residue = i % period
            if residue < numRows:
                rows[residue].append(c)
            else:
                rows[period - residue].append(c)
        return ''.join(''.join(row) for row in rows)

# assert Solution().convert('', 1) == ''
# assert Solution().convert('abcdefg', 1) == 'abcdefg'
# assert Solution().convert('', 2) == ''
# assert Solution().convert('abcde', 2) == 'acebd'

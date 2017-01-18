class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        pre, cur = [0], [0]

        for i in range(n):
            cur = []
            for j, code in enumerate(pre):
                if (j & 1):
                    cur.append((code << 1) + 1)
                    cur.append(code << 1)
                else:
                    cur.append(code << 1)
                    cur.append((code << 1) + 1)
            pre = cur

        return cur

# Solution().grayCode(1)

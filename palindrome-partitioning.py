class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        if not s:
            return []

        def find(s):
            if not s:
                return [[]]

            res = []

            for i in range(len(s)):
                left = s[:i+1]
                if left == left[::-1]:
                    right = s[i+1:]
                    for partition in find(right):
                        res.append([left] + partition)

            return res

        ans = find(s)
        return ans

# Solution().partition('aaaa')

class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        if k == 0 or n == 0:
            return []

        ans, item = [], []

        def dfs(num, left):
            if left == 0:
                ans.append(item[:])
                return
            # includes current num
            item.append(num)
            dfs(num + 1, left - 1)
            item.pop()

            # excludes current num
            if n - num >= left:
                dfs(num + 1, left)

        dfs(1, k)

        return ans

# Solution().combine(4, 2)

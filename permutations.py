class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums:
            return []

        perms = []

        def dfs(ns, prefix):
            if not ns:
                perms.append(prefix)
            else:
                for num in ns:
                    dfs(ns - {num}, prefix + [num])

        dfs(set(nums), [])

        return perms

# Solution().permute([1,2,3])

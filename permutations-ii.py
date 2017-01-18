from collections import Counter

class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans, perm = [], []
        counter, size = Counter(nums), len(nums)
        uniqueNums = counter.keys()

        def dfs(size):
            if size == 0:
                ans.append(perm[:])
                return
            for num in uniqueNums:
                if counter[num] > 0:
                    counter[num] -= 1
                    perm.append(num)
                    dfs(size - 1)
                    perm.pop()
                    counter[num] += 1

        dfs(size)

        # print("ans", ans)
        return ans

# Solution().permuteUnique([1,2,0])

class Solution(object):
    def largestDivisibleSubset(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        nums = list(sorted(nums))
        size = len(nums)

        if size <= 1:
            return nums

        counts = [1] * size
        parents = [-1] * size
        for i in range(size):
            for j in reversed(range(i)):
                if nums[i] % nums[j] == 0 and counts[j] >= counts[i]:
                    counts[i] = counts[j] + 1
                    parents[i] = j

        index = counts.index(max(counts))
        res = []
        while index != -1:
            res.append(index)
            index = parents[index]

        return [nums[i] for i in res]

# Solution().largestDivisibleSubset([1,2,4,8,9,72])

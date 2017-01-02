class Solution(object):
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        counts = [1] + [0] * (target)
        for i in range(1, target + 1):
            for num in nums:
                if num <= i:
                    counts[i] += counts[i - num]
        return counts[target]

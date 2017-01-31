class Solution(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        i = 1
        patches = 0
        numIndex, numSize = 0, len(nums)
        while i <= n:
            if numIndex < numSize and nums[numIndex] <= i:
                i += nums[numIndex]
                numIndex += 1
            else:
                i += i
                patches += 1
        return patches

# Solution().minPatches([1, 3], 6)

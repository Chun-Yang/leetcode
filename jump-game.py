class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        maxIndex = 0
        for i, num in enumerate(nums):
            if maxIndex < i:
                return False
            maxIndex = max(maxIndex, i + num)
        return True

class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        curCount = 0
        maxCount = 0
        nums.append(0)
        for num in nums:
            if num == 1:
                curCount += 1
            else:
                maxCount = max(maxCount, curCount)
                curCount = 0
        nums.pop()
        return maxCount

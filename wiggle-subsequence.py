class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size, lastPo, lastNe = len(nums), 1, 1

        for i in reversed(range(size - 1)):
            diff = nums[i] - nums[i+1]
            if diff > 0:
                lastPo = lastNe + 1
            elif diff < 0:
                lastNe = lastPo + 1

        return min(size, max(lastPo, lastNe))

class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        closeSum, size, nums = float('inf'), len(nums), sorted(nums)
        for i in range(size - 2):
            lo, hi = i + 1, size - 1
            while lo < hi:
                s = nums[lo] + nums[hi] + nums[i]
                diff = s - target
                if diff > 0:
                    hi -= 1
                elif diff < 0:
                    lo += 1
                else:
                    return target

                if abs(diff) < abs(closeSum - target):
                    closeSum = s
        return closeSum

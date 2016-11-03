from random import randint

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        less = []
        more = []
        equal = []

        pivotIndex = randint(0, len(nums) - 1)
        pivot = nums[pivotIndex]
        for num in nums:
            if num > pivot:
                more.append(num)
            elif num < pivot:
                less.append(num)
            else:
                equal.append(num)

        if k - len(more) <= 0:
            return self.findKthLargest(more, k)

        if k - len(more) - len(equal) <= 0:
            return pivot

        return self.findKthLargest(less, k - len(more) - len(equal))


# assert Solution().findKthLargest([3,2,1,5,6,4], 2) == 5

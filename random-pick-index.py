from random import random

class Solution(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        :type numsSize: int
        """
        self.nums = nums

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        index = None
        count = 0
        for i, num in enumerate(self.nums):
            if num == target:
                count += 1
                if (random() <= 1.0 / count):
                    index = i

        return index


# Your Solution object will be instantiated and called as such:
# obj = Solution([1,2,3,3,3])
# obj.pick(3)
# obj.pick(3)
# obj.pick(3)
# obj.pick(3)
# obj.pick(3)
# obj.pick(3)

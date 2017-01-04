class NumArray(object):
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        # (0, n) inclusive
        firstN = [0] * len(nums)
        for i, num in enumerate(nums):
            firstN[i] = firstN[i-1] + num
        self.firstN = firstN

    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        if i == 0:
            return self.firstN[j]
        else:
            return self.firstN[j] - self.firstN[i - 1]



# Your NumArray object will be instantiated and called as such:
# numArray = NumArray(nums)
# numArray.sumRange(0, 1)
# numArray.sumRange(1, 2)


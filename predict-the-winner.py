class Solution(object):
    def PredictTheWinner(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        numsCount = len(nums)
        if numsCount == 0:
            return True

        cache = [ [None for j in range(numsCount)] for i in range(numsCount)]

        def largerThan(left, right):
            if left == right:
                return nums[left]
            elif cache[left][right] is not None:
                return cache[left][right]
            else:
                diff = max(
                        nums[left] - largerThan(left + 1, right),
                        nums[right] - largerThan(left, right - 1)
                        )
                cache[left][right] = diff
                return diff

        return largerThan(0, numsCount - 1) >= 0

# Solution().PredictTheWinner([1, 5, 2])

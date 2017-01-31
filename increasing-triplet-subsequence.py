class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        a, b, c = float('inf'), float('inf'), float('inf')
        for num in nums:
            if num < a:
                a = num
            elif a < num < b:
                b = num
            elif num > b:
                return True

        return False

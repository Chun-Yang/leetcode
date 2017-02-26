class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        amount, bound, lo, hi = 0, 0, 0, len(height) - 1
        while lo < hi:
            if height[lo] < height[hi]:
                lower = height[lo]
                lo += 1
            else:
                lower = height[hi]
                hi -= 1
            if lower < bound:
                amount += bound - lower
            else:
                bound = lower

        return amount

# assert Solution().trap([]) == 0
# assert Solution().trap([0]) == 0
# assert Solution().trap([0, 0]) == 0
# assert Solution().trap([1, 1]) == 0
# assert Solution().trap([1, 1, 1]) == 0
# assert Solution().trap([1, 2, 1]) == 0
# assert Solution().trap([1, 0, 1]) == 1
# assert Solution().trap([1, 0, 0, 1]) == 2
# assert Solution().trap([1, 0, 0, 4]) == 2
# assert Solution().trap([3, 0, 0, 4]) == 6
# assert Solution().trap([3, 0, 2, 4]) == 4

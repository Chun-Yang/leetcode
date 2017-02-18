class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        size = len(height)
        lo, hi = 0, size - 1
        maxArea = 0

        while lo < hi:
            maxArea = max(maxArea, (hi - lo) * min(height[lo], height[hi]))
            if height[lo] > height[hi]:
                hi -= 1
            else:
                lo += 1

        return maxArea

class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        def area(left, right):
            return (right - left) * min(height[left], height[right])

        left = 0
        right = len(height) - 1
        leftMax = left
        rightMax = right
        res = area(left, right)

        while left < right:
            if height[leftMax] < height[rightMax]:
                left += 1
                if height[leftMax] < height[left]:
                    res = max(res, area(left, rightMax))
                    leftMax = left
            else:
                right -= 1
                if height[rightMax] < height[right]:
                    res = max(res, area(leftMax, right))
                    rightMax = right

        return res


# assert Solution().maxArea([2,3,4,5,18,17,6]) == 17

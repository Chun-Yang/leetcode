class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        res = 0
        left = 0
        right = len(height) - 1
        leftMax = 0
        rightMax = 0

        while left <= right:
            if leftMax <= rightMax:
                if height[left] <= leftMax:
                    res += leftMax - height[left]
                else:
                    leftMax = height[left]
                left += 1
            else:
                if height[right] <= rightMax:
                    res += rightMax - height[right]
                else:
                    rightMax = height[right]
                right -= 1

        return res

# assert Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1]) == 6
